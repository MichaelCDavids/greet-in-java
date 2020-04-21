package net.greet;


import net.greet.database.DatabaseService;
import net.greet.database.SQLQueries;
import net.greet.models.Greeting;
import net.greet.utilities.Commands;
import net.greet.utilities.Greeter;
import net.greet.utilities.Processor;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        SQLQueries queries = new SQLQueries(db);
        DatabaseService greetDatabase = new DatabaseService(queries);
        Scanner keyboard = new Scanner(System.in);
        Greeter greeterObject = new Greeter();
        Commands commands = new Commands(greeterObject, greetDatabase);
        Processor p = new Processor(commands.getAvailableCommands());
        System.out.println("Greetings in Java v1.0.0");
        while (true) {
            System.out.println("What would you like to do?");
            Greeting greeting = p.processInput(keyboard.nextLine());
            System.out.println(greeting.getMessage());

            if(!greeting.showPrompt()){
                db.close();
                break;
            }
        }
    }
}

