package net.greet.commands;

import net.greet.database.Service;
import net.greet.input.Input;
import net.greet.Command;

public class Greeted implements Command {

    private Service db;

    public Greeted( Service db){
        this.db = db;
    }

    @Override
    public String executeCommand(Input input) {
        if (input.getEnteredName() == null) {
            db.usersGreeted();
            return "";
        }
        return input.getEnteredName()+" has been greeted "+db.userGreeted(input.getEnteredName())+" times";
    }
}
