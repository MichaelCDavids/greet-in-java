package net.greet.commands;

import net.greet.data.GreetingColor;
import net.greet.Greeter;
import net.greet.database.Service;
import net.greet.input.Input;
import net.greet.Command;

public class Greet implements Command {


    private Greeter greeterObject;
    private Service db;

    public Greet(Greeter greeter, Service database){
        this.greeterObject = greeter;
        this.db = database;
    }

    public String executeCommand(Input input) {
        if (input.getEnteredName() == null) {
            return GreetingColor.RED_BRIGHT+ "For a personalized greeting enter the command "+ GreetingColor.GREEN+"$ greet [name] [language]"+ GreetingColor.RESET;
        }
        db.greetUser(input.getEnteredName());
        return greeterObject.greet(input.getEnteredName(), input.getEnteredLanguage());
    }
}
