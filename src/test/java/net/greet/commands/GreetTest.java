package net.greet.commands;



import net.greet.Command;
import net.greet.Greeter;
import net.greet.database.Service;
import net.greet.database.Queries;
import net.greet.input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreetTest {
    Connection db;
    Queries q;
    Greeter g;
    Service ds;

    Command counter;
    Command clear;
    Command greet;

    @BeforeEach
    void setup() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        g = new Greeter();
        q = new Queries(db);
        ds = new Service(q);
        counter = new Counter(ds);
        clear = new Clear(ds);
        greet = new Greet(g,ds);

        Input i = new Input("clear");
        clear.executeCommand(i);
    }

    @Test
    void testGreetConstructor() {
        assertTrue(greet instanceof Greet);
    }

    @Test
    void testGreetExecuteCommand() {
        Input i = new Input("greet Mike");
        assertEquals("Hello, Mike",greet.executeCommand(i));
    }

    @Test
    void testGreetUserExecuteCommand() {
        Greet greet = new Greet(g,ds);
        Input i1 = new Input("greet Mike");

        greet.executeCommand(i1);

        Input i2 = new Input("counter");
        assertEquals("Total number of users greeted: 1",counter.executeCommand(i2));
    }

    @Test
    void testGreetUserLanguageExecuteCommand() {
        Greet greet = new Greet(g,ds);
        Input i1 = new Input("greet Mike french");

        greet.executeCommand(i1);

        Input i2 = new Input("counter");
        assertEquals("Total number of users greeted: 1",counter.executeCommand(i2));
    }
}
