package net.greet.commands;

import net.greet.input.Input;
import net.greet.Command;

public class Exit implements Command {
    @Override
    public String executeCommand( Input input ) {
        return "Goodbye! for now";
    }
}
