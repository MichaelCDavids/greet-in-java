package net.greet.utilities;

import net.greet.database.DatabaseService;
import net.greet.database.SQLQueries;
import net.greet.interfaces.CommandInterface;
import net.greet.models.Greeting;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessorTest {
    @Test
    void testProcessorConstructor() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        assertTrue(p instanceof Processor);
    }

    @Test
    void testProcessInputMethod() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
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
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("groet Michael English");
        assertEquals("\nEnter one of these valid commands below:\n\tgreet [name]  - greets user in English\n\tgreeted [name] - number of times a user was greeted\n\tgreeted [optional] - number of users greeted\n\tclear [name] - clears user from database\n\tclear [optional] - removes all users from database\n\thelp - shows list of available commands", gp.getMessage());
    }
}
