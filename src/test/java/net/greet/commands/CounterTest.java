//package net.greet.commands;
//
//import net.greet.Command;
//import net.greet.Greeter;
//import net.greet.database.Service;
//import net.greet.database.Queries;
//import net.greet.input.Input;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class CounterTest {
//    Connection db;
//    Queries q;
//    Greeter g;
//    Service ds;
//
//    Command counter;
//    Command clear;
//
//    @BeforeEach
//    void setup() throws SQLException {
//        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
//        g = new Greeter();
//        q = new Queries(db);
//        ds = new Service(q);
//        counter = new Counter(ds);
//        clear = new Clear(ds);
//
//        Input i = new Input("clear");
//        clear.executeCommand(i);
//    }
//
//    @Test
//    void testCounterConstructor() {
//        assertTrue(counter instanceof Counter);
//    }
//
//    @Test
//    void testCounterExecuteCommand() {
//        Input i = new Input("greeted");
//        assertEquals("Total number of users greeted: 0",counter.executeCommand(i));
//    }
//
//    @Test
//    void testCounterUserExecuteCommand() {
//        Greet greet = new Greet(g,ds);
//        Input i1 = new Input("greet Mike");
//
//        greet.executeCommand(i1);
//
//        Input i2 = new Input("counter");
//        assertEquals("Total number of users greeted: 1",counter.executeCommand(i2));
//    }
//}
