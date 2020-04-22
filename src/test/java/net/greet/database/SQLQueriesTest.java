package net.greet.database;

import net.greet.utilities.Greeter;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SQLQueriesTest {
    @Test
    void testSQLQueriesConstructor() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertTrue(s instanceof SQLQueries);
    }
    @Test
    void testSQLQueriesGetFindUser() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertEquals(true,s.getFindUser() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetCreateUser() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertEquals(true,s.getCreateUser() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetUserGreetedTotal() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertEquals(true,s.getUserGreetedTotal() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetClearAllUsers() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertEquals(true,s.getClearAllUsers() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetClearUser() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertEquals(true,s.getClearUser() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetTotal() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertEquals(true,s.getTotalCount() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetUpdateCounter() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
        Greeter g = new Greeter();
        SQLQueries s = new SQLQueries(db);
        assertEquals(true,s.getUpdateCounter() instanceof PreparedStatement);
    }
}
