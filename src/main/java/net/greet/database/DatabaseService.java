package net.greet.database;


import net.greet.interfaces.DatabaseInterface;

import java.sql.*;

public class DatabaseService implements DatabaseInterface {

    private Connection connection;
    public SQLQueries queries;

    public DatabaseService(Connection connection) throws SQLException {
        this.connection = connection;
        this.queries = new SQLQueries(connection);
    }

    @Override
    public  boolean greetUser( String name ) {
        if (userExists(name)){
            return updateGreetCount(name);
        }else{
            createUser(name);
        }
        return false;
    }

    @Override
    public  int userGreeted( String name ) {
        try {
            PreparedStatement p = queries.getUserGreetedTotal();
            p.setString(1,name);
            ResultSet set = p.executeQuery();
            while (set.next()){
                System.out.println(set.getInt("COUNT"));
                return set.getInt("COUNT");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean clearUser( String name ) {
        try {
            PreparedStatement p = queries.getClearUser();
            p.setString(1,name);
            if (p.executeUpdate()>0){
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int greetCount() {
        try {
            PreparedStatement p = queries.getTotalCount();
            ResultSet set = p.executeQuery();
            set.last();
            System.out.println(set.getRow());
            return set.getRow();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean clearAll() {
        try {
            PreparedStatement p = queries.getClearAllUsers();
            if (p.executeUpdate()>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean userExists(String name){
        try {
            PreparedStatement p = queries.getFindUser();
            p.setString(1,name);
            ResultSet set = p.executeQuery();
            if (set.next()) return true;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean createUser(String name){
        try{
            PreparedStatement p = queries.getCreateUser();
            p.setString(1,name);
            p.setInt(2,1);
            if (p.executeUpdate() > 0){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateGreetCount(String name) {

        try{
            PreparedStatement p = queries.getUserGreetedTotal();
            p.setString(1, name);
            ResultSet set =  p.executeQuery();
            while (set.next()){
                int userGreetCounter = set.getInt("COUNT") + 1;
                PreparedStatement p2 = queries.getUpdateCounter();
                System.out.println(userGreetCounter);
                p2.setInt(1, userGreetCounter);
                p2.setString(2, name);
                if (p2.executeUpdate() > 0){
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

}
