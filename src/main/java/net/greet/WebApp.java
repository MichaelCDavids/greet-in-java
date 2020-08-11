package net.greet;

import net.greet.database.Queries;
import net.greet.database.Service;
import net.greet.input.Input;
import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class WebApp {
    public static void main(String[] args) {
        try {
            BasicConfigurator.configure();
            staticFiles.location("/public");
            port(getHerokuAssignedPort());
            Connection db = getDatabaseConnection("postgres://zwewdnvxoeelmi:3309911165c373cd151280f77a161d3f39c8a1ed4b7d99de454b11fef0231a80@ec2-107-22-7-9.compute-1.amazonaws.com:5432/d4h9nj3e3jnld2\n");
            AppFactory factory = new Service(new Queries(db));
            Greeter greeter = new Greeter();

            get("/", (rq, rs) -> {
                Map<String, String> data = new HashMap<>();
                data.put("counter", "" + factory.greetCount());
                return new ModelAndView(data, "index.hbs");
            }, new HandlebarsTemplateEngine());

            post("/", (rq, rs) -> {
                factory.clearAll();
                Map<String, String> data = new HashMap<>();
                data.put("counter", "" + factory.greetCount());
                return new ModelAndView(data, "index.hbs");
            }, new HandlebarsTemplateEngine());

            post("/greet", (rq, rs) -> {
                Map<String, String> data = new HashMap<>();

                String name = rq.queryParams("name").replaceAll("[^a-zA-Z]", "");
                String language = rq.queryParams("language");

                String message = "";

                if (name.isEmpty()) {
                    data.put("err", "please enter your name");
                } else {
                    if (language == null) {
                        data.put("err", "please select a language");
                    } else {
                        if (factory.greetUser(name)) {
                            message = greeter.greet(name, Input.getLanguageType(language));
                            data.put("message", message);
                        }
                    }
                }
                data.put("counter", "" + factory.greetCount());
                return new ModelAndView(data, "greet.hbs");

            }, new HandlebarsTemplateEngine());

            get("/greeted", (rq, rs) -> {
                Map<String, ArrayList<Map<String, String>>> data = new HashMap<>();
                data.put("greeted", factory.usersGreeted());
                System.out.println(data.toString());
                return new ModelAndView(data, "greeted.hbs");
            }, new HandlebarsTemplateEngine());

            get("/greeted/:username", (rq, rs) -> {
                String name = rq.params("username");

                Map<String, Object> data = new HashMap<>();

                data.put("name", name);
                data.put("counter", factory.userGreetCount(name));
                return new ModelAndView(data, "user-greeted.hbs");
            }, new HandlebarsTemplateEngine());

            get("/admin", (rq, rs) -> {
                Map<String, ArrayList<Map<String, String>>> data = new HashMap<>();
                data.put("greeted", factory.usersGreeted());
                System.out.println(data.toString());
                return new ModelAndView(data, "admin.hbs");
            }, new HandlebarsTemplateEngine());

            post("/clear/:name", (rq, rs) -> {
                Map<String, ArrayList<Map<String, String>>> data = new HashMap<>();
                factory.clearUser(rq.params("name"));
                data.put("greeted", factory.usersGreeted());
                System.out.println(data.toString());
                return new ModelAndView(data, "greeted.hbs");
            }, new HandlebarsTemplateEngine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 5000;
    }

    static Connection getDatabaseConnection(String defualtJdbcUrl) throws URISyntaxException, SQLException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        String database_url = processBuilder.environment().get("DATABASE_URL");
        if (database_url != null) {

            URI uri = new URI(database_url);
            String[] hostParts = uri.getUserInfo().split(":");
            String username = hostParts[0];
            String password = hostParts[1];
            String host = uri.getHost();

            int port = uri.getPort();

            String path = uri.getPath();
            String url = String.format("jdbc:postgresql://%s:%s%s", host, port, path);

            return DriverManager.getConnection(url, username, password);
        }
        return DriverManager.getConnection(defualtJdbcUrl);
    }
}