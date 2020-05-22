package net.greet.commands;

import net.greet.database.Service;
import net.greet.input.Input;
import net.greet.Command;

public  class Clear implements Command {

    private Service db;

    public Clear( Service database){
        this.db = database;
    }

    @Override
    public String executeCommand( Input input ) {
        if (input.getEnteredName() == null){
            db.clearAll();
            return "cleared database";
        } else if(input.getEnteredName() != null){
            if (db.clearUser(input.getEnteredName())){
                return input.getEnteredName().concat(" removed from database");
            }
            return "could not clear database for ".concat(input.getEnteredName());
        } else{
            return "could not clear database";
        }
    }
}
