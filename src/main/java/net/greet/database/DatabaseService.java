package net.greet.database;

import net.greet.interfaces.DatabaseInterface;
import net.greet.theme.ConsoleColors;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseService implements DatabaseInterface {

    SQLQueries queries;

    public DatabaseService( SQLQueries queries ) {
        this.queries = queries;
    }

    @Override
    public  boolean greetUser( String name ) {
        if (userExists(name)){
            return updateGreetCount(name);
        }else if(!userExists(name)){
            if(name!= "" | name.length() < 3){
                return createUser(name);
            }
            return false;

        } else {
            return false;
        }
    }

    @Override
    public  int userGreeted( String name ) {
        try {
            if(userExists(name)){
                PreparedStatement p = queries.getUserGreetedTotal();
                p.setString(1,name);
                ResultSet set = p.executeQuery();
                while (set.next()){
                    return set.getInt("COUNT");
                }
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
            Map<String, Integer> userMap = new HashMap<>();
            while(set.next()){
                userMap.put(set.getString(2),set.getInt(3));
            }
            return userMap.size();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String usersGreeted() {
        try {
            PreparedStatement p = queries.getTotalCount();
            ResultSet set = p.executeQuery();
            Map<String, Integer> userMap = new HashMap<>();
            System.out.println("\nList of greeted users:\n");
            while(set.next()){
                System.out.println(ConsoleColors.PURPLE_BOLD+set.getString(2)+" was greeted "+set.getInt(3)+" time(s)");
            }
            return "";

        }catch (SQLException e){
            e.printStackTrace();
        }
        return "";
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
