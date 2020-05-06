package net.greet;

import net.greet.database.DatabaseService;
import net.greet.database.SQLQueries;
import net.greet.models.Greeting;
import net.greet.utilities.Commands;
import net.greet.utilities.Greeter;
import net.greet.utilities.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest {

    Connection db;
    SQLQueries s;
    Greeter g;
    DatabaseService ds;

    @BeforeEach
    void setup() throws SQLException{
         g = new Greeter();
         db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
         s = new SQLQueries(db);
         ds = new DatabaseService(s);
    }

    @Test
    void testMainClass(){

        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("greet Michael English");
        assertEquals("Hello, Michael",gp.getMessage());
    }
    @Test
    void testMainClassPrompt(){
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("greet Michael English");
        assertEquals(true,gp.showPrompt());
    }
    @Test
    void testMainClassPromptExit() {
        Commands c = new Commands(g,ds);
        Processor p = new Processor(c.getAvailableCommands());
        Greeting gp = p.processInput("exit");
        assertFalse(gp.showPrompt());
    }
}
