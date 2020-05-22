package net.greet;

import net.greet.input.Input;
import net.greet.models.Greeting;
import net.greet.data.GreetingColor;

public class Processor {


    Commands commands;

    public Processor(Commands commands){
        this.commands = commands;
    }

    public Greeting processInput( String input){
        Input userInput = new Input(input);
        if (commands.getCommand(userInput.getCommandType().name().toLowerCase()) instanceof Command){
            if (userInput.getCommandType().name().toLowerCase().equals("exit")){
                return new Greeting(commands.getCommand(userInput.getCommandType().name().toLowerCase()).executeCommand(userInput),false);
            }
            return new Greeting(commands.getCommand(userInput.getCommandType().name().toLowerCase()).executeCommand(userInput),true);
        }
        return new Greeting(GreetingColor.GREEN+"type help for a list of valid commads"+ GreetingColor.RESET,true);
    }


}
