package net.greet;

import net.greet.commands.*;
import net.greet.database.Service;
import net.greet.database.Queries;
import net.greet.models.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    Connection db;
    Queries s;
    Greeter g;
    Service ds;

    @BeforeEach
    void setup() throws SQLException{
         g = new Greeter();
         db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
         s = new Queries(db);
         ds = new Service(s);
    }

    @Test
    void testMainClass(){
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("greet",new Greet(g, ds));
        commandMap.put("greeted",new Greeted(ds));
        commandMap.put("counter",new Counter(ds));
        commandMap.put("clear",new Clear(ds));
        commandMap.put("help",new Help());
        commandMap.put("exit",new Exit());
        Commands c = new Commands(commandMap);
        Processor p = new Processor(c);
        Greeting gp = p.processInput("greet Michael English");
        assertEquals("Hello, Michael",gp.getMessage());
    }

}
