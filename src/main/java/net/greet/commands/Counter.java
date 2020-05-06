package net.greet.commands;


import net.greet.database.DatabaseService;
import net.greet.enumerators.CommandType;
import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;

public class Counter implements CommandInterface {

    private DatabaseService db;

    public Counter(DatabaseService db){
        this.db = db;
    }

    @Override
    public String executeCommand(Input input) {
            return "Total number of users greeted: " +  db.greetCount();
    }
}