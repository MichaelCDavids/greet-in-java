package net.greet.commands;

import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;

public class Exit implements CommandInterface {
    @Override
    public String executeCommand( Input input ) {
        return "Goodbye! for now";
    }
}
