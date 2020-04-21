package net.greet.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLQueries {


    //create
    private final String CREATE_USER_SQL = "INSERT INTO USERS (NAME,COUNT) VALUES (?,?)";
    private PreparedStatement createUser;

    // read
    private final String GET_USER_TOTAL_SQL = "SELECT * FROM USERS";
    private PreparedStatement totalCount;

    private final String GET_USER_SQL = "SELECT 1 FROM USERS WHERE NAME = ?";
    private PreparedStatement findUser;

    private final String GET_USER_GREETED_COUNT = "SELECT COUNT FROM USERS WHERE NAME = ?";
    private PreparedStatement userGreetedTotal;

    // update
    private final String UPDATE_COUNTER_SQL = "UPDATE USERS SET COUNT = ? WHERE NAME = ?";
    private PreparedStatement updateCounter;

    // delete
    private final String CLEAR_USER_SQL = "DELETE FROM USERS WHERE NAME = ?";
    private PreparedStatement clearUser;

    private final String CLEAR_ALL_USERS_SQL = "DELETE FROM USERS";
    private PreparedStatement clearAllUsers;

    public SQLQueries(Connection dbConnection) {
        try{
            this.findUser = dbConnection.prepareStatement(GET_USER_SQL);
            this.userGreetedTotal = dbConnection.prepareStatement(GET_USER_GREETED_COUNT);
            this.createUser = dbConnection.prepareStatement(CREATE_USER_SQL);
            this.updateCounter =  dbConnection.prepareStatement(UPDATE_COUNTER_SQL);
            this.totalCount = dbConnection.prepareStatement(GET_USER_TOTAL_SQL);
            this.clearUser = dbConnection.prepareStatement(CLEAR_USER_SQL);
            this.clearAllUsers =  dbConnection.prepareStatement(CLEAR_ALL_USERS_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    PreparedStatement getFindUser() {
        return findUser;
    }

    PreparedStatement getCreateUser() {
        return createUser;
    }

    PreparedStatement getUpdateCounter() {
        return updateCounter;
    }

    PreparedStatement getTotalCount() {
        return totalCount;
    }

    PreparedStatement getClearUser() {
        return clearUser;
    }

    PreparedStatement getClearAllUsers() {
        return clearAllUsers;
    }

    PreparedStatement getUserGreetedTotal() {
        return userGreetedTotal;
    }
}
