package net.greet;

import net.greet.commands.*;
import net.greet.data.GreetingColor;
import net.greet.database.Queries;
import net.greet.database.Service;
import net.greet.models.Greeting;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static net.greet.WebApp.getDatabaseConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner keyboard = new Scanner(System.in);

//        Connection db = getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        try {
            Connection db = getDatabaseConnection("jdbc:postgresql://localhost/greeter?user=mike&password=mike123");
            Map<String, Command> listOfCommands = new HashMap<>();
            listOfCommands.put("greet", new Greet(new Greeter(), new Service(new Queries(db))));
            listOfCommands.put("greeted", new Greeted(new Service(new Queries(db))));
            listOfCommands.put("counter", new Counter(new Service(new Queries(db))));
            listOfCommands.put("clear", new Clear(new Service(new Queries(db))));
            listOfCommands.put("help", new Help());
            listOfCommands.put("exit", new Exit());
            Commands commands = new Commands(listOfCommands);
            Processor p = new Processor(commands);
            System.out.println("Greetings App v1.0.0");
            while (true) {
                System.out.print(GreetingColor.CYAN_BOLD + "Enter command\n> " + GreetingColor.RESET);
                Greeting greeting = p.processInput(keyboard.nextLine());
                System.out.println(greeting.getMessage());
                if (!greeting.showPrompt()) {
                    db.close();
                    break;
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}

