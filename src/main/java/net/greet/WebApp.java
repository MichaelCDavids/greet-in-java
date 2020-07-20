package net.greet;

import net.greet.database.Queries;
import net.greet.database.Service;
import net.greet.input.Input;
import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.sql.DriverManager.getConnection;
import static spark.Spark.*;

public class WebApp {
    public static void main(String[] args) {
        try{
            BasicConfigurator.configure();

            Connection db = getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
            Service factory = new Service(new Queries(db));
            Greeter greeter =  new Greeter();

            get("/",  (rq, rs) -> {
                Map<String, String> data = new HashMap<>();
                data.put("counter", ""+factory.greetCount());
                return new ModelAndView(data, "index.hbs");
            }, new HandlebarsTemplateEngine());

            post("/",  (rq, rs) -> {
                factory.clearAll();
                Map<String, String> data = new HashMap<>();
                data.put("counter", ""+factory.greetCount());
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
                    }else{
                        if(factory.greetUser(name)){
                            message = greeter.greet(name, Input.getLanguageType(language));
                            data.put("message", message);
                        }
                    }
                }
                data.put("counter", ""+factory.greetCount());
                return new ModelAndView(data, "greet.hbs");

            }, new HandlebarsTemplateEngine());

            get("/greeted", (rq, rs) -> {
                Map<String, ArrayList<Map<String,String>>> data = new HashMap<>();
                data.put("greeted",factory.usersGreeted());
                System.out.println(data.toString());
                return new ModelAndView(data, "greeted.hbs");
            }, new HandlebarsTemplateEngine());

            get("/admin", (rq, rs) -> {
                Map<String, ArrayList<Map<String,String>>> data = new HashMap<>();
                data.put("greeted",factory.usersGreeted());
                System.out.println(data.toString());
                return new ModelAndView(data, "admin.hbs");
            }, new HandlebarsTemplateEngine());

            post("/clear/:name",(rq,rs) -> {
                Map<String, ArrayList<Map<String,String>>> data = new HashMap<>();
                factory.clearUser(rq.params("name"));
                data.put("greeted",factory.usersGreeted());
                System.out.println(data.toString());
                return new ModelAndView(data, "greeted.hbs");
            },new HandlebarsTemplateEngine());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}