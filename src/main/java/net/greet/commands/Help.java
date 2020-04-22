package net.greet.commands;

import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;

public class Help implements CommandInterface {

    public String executeCommand( Input input ) {
        return "\nEnter one of these valid commands below:\n\tgreet [name]  - greets user in English\n\tgreeted [name] - number of times a user was greeted\n\tgreeted [optional] - number of users greeted\n\tclear [name] - clears user from database\n\tclear [optional] - removes all users from database\n\thelp - shows list of available commands";
    }
}
