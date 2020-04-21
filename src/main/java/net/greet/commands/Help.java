package net.greet.commands;

import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;

public class Help implements CommandInterface {

    public String executeCommand( Input input ) {
        return "Help is on the way";
    }
}
