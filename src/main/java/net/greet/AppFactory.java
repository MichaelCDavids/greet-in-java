package net.greet;

import java.util.ArrayList;
import java.util.Map;

public interface AppFactory {
    boolean greetUser(String userName);
    int userGreeted(String userName);
    boolean clearUser(String userName);
    int greetCount();
    boolean clearAll();
    ArrayList<Map<String,String>> usersGreeted();
    int userGreetCount(String name);
}
