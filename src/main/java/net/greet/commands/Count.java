package net.greet.commands;

import net.greet.database.DatabaseService;
import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;

public class Count implements CommandInterface {

    private DatabaseService db;

    public Count(DatabaseService db){
        this.db = db;
    }

    @Override
    public String executeCommand(Input input) {
        if (input.getEnteredName() != null) {
            return input.getEnteredName() + " was greeted: " + db.userGreeted(input.getEnteredName()) + " times";
        }
        return "Total number of users greeted: " +  db.greetCount();
    }
}
