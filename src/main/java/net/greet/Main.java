package net.greet;

import net.greet.commands.*;
import net.greet.database.Service;
import net.greet.database.Queries;
import net.greet.models.Greeting;
import net.greet.data.GreetingColor;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.sql.DriverManager.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        Connection db = getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Map<String, Command> listOfCommands = new HashMap<>();
        listOfCommands.put("greet",new Greet(new Greeter(), new Service(new Queries(db))));
        listOfCommands.put("greeted",new Greeted(new Service(new Queries(db))));
        listOfCommands.put("counter",new Counter(new Service(new Queries(db))));
        listOfCommands.put("clear",new Clear(new Service(new Queries(db))));
        listOfCommands.put("help",new Help());
        listOfCommands.put("exit",new Exit());
        Commands commands = new Commands(listOfCommands);
        Processor p = new Processor(commands);
        System.out.println("Greetings App v1.0.0");
        while (true) {
            System.out.print(GreetingColor.CYAN_BOLD+"Enter command\n> "+GreetingColor.RESET);
            Greeting greeting = p.processInput(keyboard.nextLine());
            System.out.println(greeting.getMessage());
            if(!greeting.showPrompt()){
                db.close();
                break;
            }
        }
    }
}

