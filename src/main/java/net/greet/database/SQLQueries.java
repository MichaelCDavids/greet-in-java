package net.greet.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLQueries {

    private Connection connection;

    private PreparedStatement createUser;
    private PreparedStatement totalCount;
    private PreparedStatement findUser;
    private PreparedStatement userGreetedTotal;
    private PreparedStatement updateCounter;
    private PreparedStatement clearUser;
    private PreparedStatement clearAllUsers;

    public SQLQueries(Connection dbConnection){
        this.connection = dbConnection;
    }

    PreparedStatement getFindUser() {
        try {
            final String GET_USER_SQL = "SELECT 1 FROM USERS WHERE NAME = ?";
            this.findUser = this.connection.prepareStatement(GET_USER_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return findUser;
    }

    PreparedStatement getCreateUser() {
        try{
            final String CREATE_USER_SQL = "INSERT INTO USERS (NAME,COUNT) VALUES (?,?)";
            this.createUser = this.connection.prepareStatement(CREATE_USER_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return createUser;
    }

    PreparedStatement getUpdateCounter() {
        try {
            final String UPDATE_COUNTER_SQL = "UPDATE USERS SET COUNT = ? WHERE NAME = ?";
            this.updateCounter =  this.connection.prepareStatement(UPDATE_COUNTER_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return updateCounter;
    }

    PreparedStatement getTotalCount() {
        try {
            final String GET_USER_TOTAL_SQL = "SELECT * FROM USERS";

            this.totalCount = this.connection.prepareStatement(GET_USER_TOTAL_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return totalCount;
    }

    PreparedStatement getClearUser() {
        try {
            final String CLEAR_USER_SQL = "DELETE FROM USERS WHERE NAME = ?";
            this.clearUser = this.connection.prepareStatement(CLEAR_USER_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clearUser;
    }

    PreparedStatement getClearAllUsers() {
        try {
            final String CLEAR_ALL_USERS_SQL = "DELETE FROM USERS";
            this.clearAllUsers =  this.connection.prepareStatement(CLEAR_ALL_USERS_SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clearAllUsers;
    }

    PreparedStatement getUserGreetedTotal() {
        try{
            final String GET_USER_GREETED_COUNT = "SELECT COUNT FROM USERS WHERE NAME = ?";
            this.userGreetedTotal = this.connection.prepareStatement(GET_USER_GREETED_COUNT);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userGreetedTotal;
    }
}
