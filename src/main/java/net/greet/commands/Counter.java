package net.greet.commands;


import net.greet.database.Service;
import net.greet.input.Input;
import net.greet.Command;

public class Counter implements Command {

    private Service db;

    public Counter( Service db){
        this.db = db;
    }

    @Override
    public String executeCommand(Input input) {
            return "Total number of users greeted: " +  db.greetCount();
    }
}