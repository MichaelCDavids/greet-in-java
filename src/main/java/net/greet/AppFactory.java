package net.greet;

public interface AppFactory {
    boolean greetUser(String userName);
    int userGreeted(String userName);
    boolean clearUser(String userName);
    int greetCount();
    boolean clearAll();
    String usersGreeted();
}
