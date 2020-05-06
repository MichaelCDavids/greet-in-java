package net.greet.utilities;

import net.greet.database.DatabaseService;
import net.greet.database.SQLQueries;
import net.greet.models.Greeting;
import net.greet.theme.ConsoleColors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessorTest {
    Connection db;

    @BeforeEach
    void setup() throws SQLException {
         db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
    }

    @Test
    void testProcessorConstructor() throws SQLException {
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        assertTrue(p instanceof Processor);
    }

    @Test
    void testProcessInputMethod() throws SQLException {
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("greet Michael English");
        assertEquals("Hello, Michael",gp.getMessage());
    }
    @Test
    void testProcessInputMethodInvalidCommand() throws SQLException {
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("groet Michael English");
        assertEquals("==================================================================" +
                "\nEnter one of these valid commands below:\n" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tgreet [name] [language] "+ConsoleColors.RESET+"- Greets a user in preferred language" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tgreeted "+ConsoleColors.RESET+"- Displays a list of all users that were greeted and number of they have been greeted" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tgreeted [name] "+ConsoleColors.RESET+"- number of times a user was greeted" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tcounter "+ConsoleColors.RESET+"- Displays the total number of users that were greeted" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tclear [name] "+ConsoleColors.RESET+"- clears user from database" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tclear "+ConsoleColors.RESET+"- removes all users from database" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\thelp "+ConsoleColors.RESET+"- shows list of available commands" +
                "\n================================================================" , gp.getMessage());
    }
}
