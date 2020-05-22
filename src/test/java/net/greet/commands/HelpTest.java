package net.greet.commands;

import net.greet.Command;
import net.greet.Greeter;
import net.greet.data.GreetingColor;
import net.greet.database.Queries;
import net.greet.database.Service;
import net.greet.input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpTest {
    Connection db;
    Queries q;
    Greeter g;
    Service ds;

    Command help;

    @BeforeEach
    void setup() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        g = new Greeter();
        q = new Queries(db);
        ds = new Service(q);
        help = new Help();
    }

    @Test
    void testExit(){
        Input i = new Input("help");
        assertEquals("==================================================================" +
                "\nEnter one of these valid commands below:\n" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreet [name] [language] "+ GreetingColor.RESET+"- Greets a user in preferred language" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreeted "+ GreetingColor.RESET+"- Displays a list of all users that were greeted and number of they have been greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreeted [name] "+ GreetingColor.RESET+"- number of times a user was greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tcounter "+ GreetingColor.RESET+"- Displays the total number of users that were greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tclear [name] "+ GreetingColor.RESET+"- clears user from database" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tclear "+ GreetingColor.RESET+"- removes all users from database" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\thelp "+ GreetingColor.RESET+"- shows list of available commands" +
                "\n================================================================", help.executeCommand(i));

    }
}
