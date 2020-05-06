package net.greet.input;

import net.greet.enumerators.CommandType;
import net.greet.enumerators.LanguageType;

public class Input {

    private String [] arguments;

    public Input(String argumentString){
        this.arguments = argumentString.split(" ");
    }

    public CommandType getCommandType() {
        return getCommandType(this.arguments[0]);
    }

    public String getEnteredName() {
        if (this.arguments.length >= 2){
            return arguments[1].substring(0,1).toUpperCase()+arguments[1].substring(1).toLowerCase();
        }
        return null;
    }

    public LanguageType getEnteredLanguage() {
        if (this.arguments.length > 2){
            return getLanguageType(arguments[2]);
        }
        return LanguageType.ENGLISH;
    }

    private LanguageType getLanguageType(String arg){
        for (LanguageType type : LanguageType.values()) {
            if (type.name().equals(arg.toUpperCase())) {
                return type;
            }
        }
        return LanguageType.ENGLISH;
    }

    private CommandType getCommandType(String arg){
        for (CommandType type : CommandType.values()) {
            if (type.name().equals(arg.toUpperCase())) {
                return type;
            }
        }
        return CommandType.HELP;
    }
    protected int getArgumentsLength(){
        return this.arguments.length;
    }
}
