package net.greet.commands;

import net.greet.database.DatabaseService;
import net.greet.enumerators.CommandType;
import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;
import net.greet.theme.ConsoleColors;

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
        return ConsoleColors.RED+input.getEnteredName()+" was not greeted before"+ConsoleColors.RESET;
    }
}
