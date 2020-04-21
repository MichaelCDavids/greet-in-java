package net.greet.utilities;

import net.greet.enumerators.CommandType;
import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;
import net.greet.models.Greeting;

import java.util.Map;

public class Processor {

    Map<String, CommandInterface> commands;

    public Processor( Map<String, CommandInterface> commands ){
        this.commands = commands;
    }

    public Greeting processInput( String input){
        Input userInput = new Input(input);
        boolean validCommand = commands.containsKey(userInput.getCommandType().name().toLowerCase());
        boolean exitApp = userInput.getCommandType().name().toLowerCase().equals("exit");
        if (validCommand){
            if (exitApp){
                return new Greeting(commands.get(userInput.getCommandType().name().toLowerCase()).executeCommand(userInput),false);
            }else{
                return new Greeting(commands.get(userInput.getCommandType().name().toLowerCase()).executeCommand(userInput),true);
            }
        }
        return new Greeting("could not process your request, try again",true);
    }


}
