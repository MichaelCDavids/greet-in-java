package net.greet;

import net.greet.input.Input;

public interface Command {
    String executeCommand( Input input );
}
