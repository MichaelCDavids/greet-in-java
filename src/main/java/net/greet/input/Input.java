package net.greet.input;

import net.greet.enums.Command;
import net.greet.enums.Language;

public class Input {

    private String [] arguments;

    public Input(String argumentString){
        this.arguments = argumentString.split(" ");
    }

    public Command getCommandType() {
        return getCommandType(this.arguments[0]);
    }

    public String getEnteredName() {
        if (this.arguments.length >= 2){
            String name = arguments[1].replaceAll("[^a-zA-Z]", "");
            return name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        }
        return null;
    }

    public Language getEnteredLanguage() {
        if (this.arguments.length > 2){
            return getLanguageType(arguments[2]);
        }
        return Language.ENGLISH;
    }

    public static Language getLanguageType( String arg){
        for (Language type : Language.values()) {
            if (type.name().equals(arg.toUpperCase())) {
                return type;
            }
        }
        return Language.ENGLISH;
    }

    private Command getCommandType( String arg){
        for (Command type : Command.values()) {
            if (type.name().equals(arg.toUpperCase())) {
                return type;
            }
        }
        return Command.HELP;
    }

    protected int getArgumentsLength(){
        return this.arguments.length;
    }
}
