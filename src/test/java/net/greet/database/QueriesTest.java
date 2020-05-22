package net.greet.database;

import net.greet.Greeter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueriesTest {
    Connection db;

    @BeforeEach
    void setUp() throws SQLException {
        db = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
    }
    @Test
    void testSQLQueriesConstructor() {
        Queries s = new Queries(db);
        assertTrue(s instanceof Queries);
    }
    @Test
    void testSQLQueriesGetFindUser() throws SQLException {
        Queries s = new Queries(db);
        assertEquals(true,s.getFindUser() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetCreateUser() throws SQLException {
        Greeter g = new Greeter();
        Queries s = new Queries(db);
        assertEquals(true,s.getCreateUser() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetUserGreetedTotal() throws SQLException {
        Queries s = new Queries(db);
        assertEquals(true,s.getUserGreetedTotal() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetClearAllUsers() throws SQLException {
        Greeter g = new Greeter();
        Queries s = new Queries(db);
        assertEquals(true,s.getClearAllUsers() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetClearUser() throws SQLException {
        Greeter g = new Greeter();
        Queries s = new Queries(db);
        assertEquals(true,s.getClearUser() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetTotal() throws SQLException {
        Queries s = new Queries(db);
        assertEquals(true,s.getTotalCount() instanceof PreparedStatement);
    }
    @Test
    void testSQLQueriesGetUpdateCounter() throws SQLException {
        Queries s = new Queries(db);
        assertEquals(true,s.getUpdateCounter() instanceof PreparedStatement);
    }
}
