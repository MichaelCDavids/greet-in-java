package net.greet.utilities;

import net.greet.commands.*;
import net.greet.database.DatabaseService;
import net.greet.interfaces.CommandInterface;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    private Greeter greeterObject;
    private DatabaseService greetDatabase;
    private Map<String, CommandInterface> availableCommands = new HashMap<>();;

    public Commands( Greeter greeterObject, DatabaseService databaseApp){
        this.greetDatabase = databaseApp;
        this.greeterObject = greeterObject;
        initializeCommands();
    }

    private void initializeCommands(){
        getAvailableCommands().put("greet",new Greet(greeterObject, greetDatabase));
        getAvailableCommands().put("greeted",new Greeted(greetDatabase));
        getAvailableCommands().put("counter",new Counter(greetDatabase));
        getAvailableCommands().put("clear",new Clear(greetDatabase));
        getAvailableCommands().put("help",new Help());
        getAvailableCommands().put("exit",new Exit());
    }

    public Map<String, CommandInterface> getAvailableCommands() {
        return availableCommands;
    }
}
