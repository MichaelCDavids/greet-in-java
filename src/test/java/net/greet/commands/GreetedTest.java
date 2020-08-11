package net.greet.commands;

import net.greet.Command;
import net.greet.Greeter;
import net.greet.database.Queries;
import net.greet.database.Service;
import net.greet.input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreetedTest {
    Connection db;
    Queries q;
    Greeter g;
    Service ds;

    Command greeted,  greet, clear;

    @BeforeEach
    void setup() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        g = new Greeter();
        q = new Queries(db);
        ds = new Service(q);
        greeted = new Greeted(ds);
        greet = new Greet(g,ds);
        clear = new Clear(ds);
        Input i1 = new Input("clear");
        clear.executeCommand(i1);
    }

    @Test
    void testGreetedConstructor() {
        assertTrue(greeted instanceof Greeted);
    }

    @Test
    void testGreetedExecuteCommand() {
        Input i1 = new Input("greet Mike");

        greet.executeCommand(i1);
        Input i = new Input("greeted Mike");
        assertEquals("Mike has been greeted 1 times",greeted.executeCommand(i));
    }

    @Test
    void testGreetedUserExecuteCommand() {
        Greet greet = new Greet(g,ds);
        Input i1 = new Input("greet Mike");

        greet.executeCommand(i1);
        greet.executeCommand(i1);
        greet.executeCommand(i1);
        greet.executeCommand(i1);

        Input i2 = new Input("greeted Mike");
        assertEquals("Mike has been greeted 4 times",greeted.executeCommand(i2));
    }
}
