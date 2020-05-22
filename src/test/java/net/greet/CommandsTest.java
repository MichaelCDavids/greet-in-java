package net.greet;

import net.greet.commands.*;
import net.greet.database.Service;
import net.greet.database.Queries;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandsTest {

    Connection db;
    Commands c;

    @BeforeEach
    void setup() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("greet",new Greet(new Greeter(), new Service(new Queries(db))));
        commandMap.put("greeted",new Greeted(new Service(new Queries(db))));
        commandMap.put("counter",new Counter(new Service(new Queries(db))));
        commandMap.put("clear",new Clear(new Service(new Queries(db))));
        commandMap.put("help",new Help());
        commandMap.put("exit",new Exit());
        c = new Commands(commandMap);
    }

    @Test
    void testCommandsConstructor() {
        assertTrue(c instanceof Commands);
    }

    @Test
    void testGetAvailableCommands() {
        assertTrue(c.getCommand("greet") instanceof Greet);
    }


}
