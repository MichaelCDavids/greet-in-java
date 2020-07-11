package net.greet;

import net.greet.commands.*;
import net.greet.database.Service;
import net.greet.database.Queries;
import net.greet.models.Greeting;
import net.greet.data.GreetingColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessorTest {
    Connection db;
    Queries q;
    Greeter g;
    Service ds;
    Processor p;

    @BeforeEach
    void setup() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        g =  new Greeter();
        q = new Queries(db);
        ds = new Service(q);
        Map<String, Command> commandMap = new HashMap<>();
        commandMap.put("greet",new Greet(g, ds));
        commandMap.put("greeted",new Greeted(ds));
        commandMap.put("counter",new Counter(ds));
        commandMap.put("clear",new Clear(ds));
        commandMap.put("help",new Help());
        commandMap.put("exit",new Exit());
        Commands c = new Commands(commandMap);
        p = new Processor(c);
    }

    @Test
    void testProcessorConstructor() {
        assertTrue(p instanceof Processor);
    }

    @Test
    void testProcessInputMethod() {
        assertEquals("Hello, Daiyaan",  p.processInput("greet Daiyaan").getMessage());
    }
    @Test
    void testProcessInputMethodInvalidCommand() throws SQLException {

        assertEquals("==================================================================" +
                "\nEnter one of these valid commands below:" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreet [name] [language] "+ GreetingColor.RESET+"- Greets a user in preferred language" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreeted "+ GreetingColor.RESET+"- Displays a list of all users that were greeted and number of they have been greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreeted [name] "+ GreetingColor.RESET+"- number of times a user was greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tcounter "+ GreetingColor.RESET+"- Displays the total number of users that were greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tclear [name] "+ GreetingColor.RESET+"- clears user from database" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tclear "+ GreetingColor.RESET+"- removes all users from database" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\thelp "+ GreetingColor.RESET+"- shows list of available commands" +
                "\n================================================================"  , p.processInput("groet Mujahid engels").getMessage());
    }
}
