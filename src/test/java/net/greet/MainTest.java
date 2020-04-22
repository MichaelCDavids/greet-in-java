package net.greet;

import net.greet.database.DatabaseService;
import net.greet.database.SQLQueries;
import net.greet.models.Greeting;
import net.greet.utilities.Commands;
import net.greet.utilities.Greeter;
import net.greet.utilities.Processor;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest {

    @Test
    void testMainClass() throws SQLException {
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
    void testMainClassPrompt() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("greet Michael English");
        assertEquals(true,gp.showPrompt());
    }
    @Test
    void testMainClassPromptExit() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("exit");
        assertFalse(gp.showPrompt());
    }
}
