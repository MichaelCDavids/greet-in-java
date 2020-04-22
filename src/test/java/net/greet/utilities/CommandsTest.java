package net.greet.utilities;

import net.greet.commands.*;
import net.greet.database.DatabaseService;
import net.greet.database.SQLQueries;
import net.greet.interfaces.CommandInterface;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandsTest {
    @Test
    void testCommandsConstructor() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        assertEquals(5, c.getAvailableCommands().size());
    }

    @Test
    void testGetAvailableCommands() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Map<String, CommandInterface> m = new HashMap<>();
        assertTrue(c.getAvailableCommands() instanceof HashMap);
    }

    @Test
    void testGetAvailableCommandsSize() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        DatabaseService ds = new DatabaseService(s);
        Commands c = new Commands(g,ds);
        Map<String, CommandInterface> m = new HashMap<>();
        assertEquals(5,c.getAvailableCommands().size());
    }
}
