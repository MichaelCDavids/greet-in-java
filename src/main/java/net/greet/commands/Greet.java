package net.greet.commands;

import net.greet.utilities.Greeter;
import net.greet.database.DatabaseService;
import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;

public class Greet implements CommandInterface {


    private Greeter greeterObject;
    private DatabaseService db;

    public Greet(Greeter greeter, DatabaseService database){
        this.greeterObject = greeter;
        this.db = database;
    }

    public String executeCommand(Input input) {
        if (input.getEnteredName() == null) {
            return "use command $greet [name]";
        }
        db.greetUser(input.getEnteredName());
        return greeterObject.greet(input.getEnteredName(), input.getEnteredLanguage());
    }
}
