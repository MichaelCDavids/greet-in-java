package net.greet.interfaces;

public interface DatabaseInterface {
    boolean greetUser(String userName);
    int userGreeted(String userName);
    boolean clearUser(String userName);
    int greetCount();
    boolean clearAll();
}
