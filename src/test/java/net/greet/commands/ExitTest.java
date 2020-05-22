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

public class ExitTest {
    Connection db;
    Queries q;
    Greeter g;
    Service ds;

    Command exit;

    @BeforeEach
    void setup() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        g = new Greeter();
        q = new Queries(db);
        ds = new Service(q);
        exit = new Exit();
    }

    @Test
    void testExit(){
        Input i = new Input("exit");
        assertEquals("Goodbye! for now", exit.executeCommand(i));

    }
}
