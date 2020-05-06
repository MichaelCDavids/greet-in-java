package net.greet.commands;

import net.greet.theme.ConsoleColors;
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
            return ConsoleColors.RED_BRIGHT+ "To greet a user enter the command "+ConsoleColors.GREEN+"$ greet [name] [language]"+ConsoleColors.RESET;
        }
        db.greetUser(input.getEnteredName());
        return greeterObject.greet(input.getEnteredName(), input.getEnteredLanguage());
    }
}
