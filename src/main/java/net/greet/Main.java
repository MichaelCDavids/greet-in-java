package net.greet;


import net.greet.database.DatabaseService;
import net.greet.database.SQLQueries;
import net.greet.models.Greeting;
import net.greet.theme.ConsoleColors;
import net.greet.utilities.Commands;
import net.greet.utilities.Greeter;
import net.greet.utilities.Processor;

import java.sql.*;
import java.util.Scanner;

import static java.sql.DriverManager.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection db = getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        SQLQueries queries = new SQLQueries(db);
        DatabaseService greetDatabase = new DatabaseService(queries);
        Scanner keyboard = new Scanner(System.in);
        Greeter greeterObject = new Greeter();
        Commands commands = new Commands(greeterObject, greetDatabase);
        Processor p = new Processor(commands.getAvailableCommands());
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Greetings in Java v1.0.0"+ConsoleColors.RESET);
        while (true) {
            System.out.print(ConsoleColors.CYAN_BOLD+"please enter command:\n> "+ConsoleColors.RESET);
            Greeting greeting = p.processInput(keyboard.nextLine());
            System.out.println(greeting.getMessage());
            if(!greeting.showPrompt()){
                db.close();
                break;
            }
        }
    }
}

