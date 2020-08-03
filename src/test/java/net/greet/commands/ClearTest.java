//package net.greet;
//
//import net.greet.commands.*;
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
//public class ClearTest {
//    Connection db;
//    Queries q;
//    Greeter g;
//    Service ds;
//
//    Command clear;
//
//    @BeforeEach
//    void setup() throws SQLException {
//        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
//        g = new Greeter();
//        q = new Queries(db);
//        ds = new Service(q);
//        clear = new Clear(ds);
//        assertTrue(clear instanceof  Command);
//
//    }
//
//    @Test
//    void testClearConstructor() {
//        assertTrue(clear instanceof Clear);
//    }
//
//    @Test
//    void testClearExecuteCommand() {
//        Input i = new Input("clear");
//        assertEquals("cleared database",clear.executeCommand(i));
//    }
//
//    @Test
//    void testClearUserExecuteCommand() {
//
//        Greet greet = new Greet(g,ds);
//
//        Input i1 = new Input("greet Mike");
//        greet.executeCommand(i1);
//
//        Input i2 = new Input("clear Mike");
//        assertEquals("Mike removed from database",clear.executeCommand(i2));
//    }
//
//    @Test
//    void testClearUserNotGreetedBeforeExecuteCommand() {
//
//
//
//        Input i1 = new Input("clear");
//        Input i2 = new Input("clear Mike");
//        clear.executeCommand(i1);
//        assertEquals("could not clear database for Mike",clear.executeCommand(i2));
//    }
//
//
//}
