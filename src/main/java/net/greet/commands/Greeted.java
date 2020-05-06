package net.greet.commands;

import net.greet.database.DatabaseService;
import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;
import net.greet.theme.ConsoleColors;

public class Greeted implements CommandInterface {

    private DatabaseService db;

    public Greeted(DatabaseService db){
        this.db = db;
    }

    @Override
    public String executeCommand(Input input) {
        if (input.getEnteredName() == null) return db.usersGreeted();
        return input.getEnteredName()+" has been greeted "+db.userGreeted(input.getEnteredName())+" times";
    }
}
