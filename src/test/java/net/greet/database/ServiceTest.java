package net.greet.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    final String  CONNECTION_URL = "jdbc:h2:file:./target/greetings_app_db";
    Connection db;

    @BeforeEach
    void clearUsersTable() throws SQLException {
        db = DriverManager.getConnection(CONNECTION_URL, "sa", "");
        Queries s = new Queries(db);
        Service ds = new Service(s);
        ds.clearAll();
    }

    @Test
    void testDatabaseServicesConstructor() throws SQLException {
        Queries s = new Queries(db);
        Service ds = new Service(s);
        assertTrue(ds instanceof Service);
    }

    @Test
    void testDatabaseServicesGreetUser() throws SQLException {
        Queries s = new Queries(db);
        Service ds = new Service(s);
        assertTrue(ds.greetUser("Michael"));
    }
    @Test
    void testDatabaseServiceUserGreeted() throws SQLException {
        Queries s = new Queries(db);
        Service ds = new Service(s);
        ds.greetUser("Michael");
        assertEquals(1,ds.userGreeted("Michael"));
    }
    @Test
    void testDatabaseServiceClearUser() throws SQLException {
        Queries s = new Queries(db);
        Service ds = new Service(s);
        ds.greetUser("Michael");
        assertEquals(true,ds.clearUser("Michael"));
        assertEquals(0,ds.userGreeted("Michael"));
    }
    @Test
    void testDatabaseServiceGreetCount() throws SQLException {
        Queries s = new Queries(db);
        Service ds = new Service(s);
        ds.greetUser("Daiyaan");
        ds.greetUser("Amirah");
        ds.greetUser("Michael");
        ds.greetUser("Yiggy");
        ds.greetUser("Michael");
        ds.greetUser("Thabang");
        ds.greetUser("Michael");
        ds.greetUser("Vuskov");
        ds.greetUser("Tso");
        assertEquals(7,ds.greetCount());
    }

    @Test
    void testDatabaseServiceClearAll() throws SQLException {
        Queries s = new Queries(db);
        Service ds = new Service(s);
        ds.greetUser("Michael");
        assertTrue(ds.clearAll());
        assertEquals(0,ds.greetCount());
    }
}
