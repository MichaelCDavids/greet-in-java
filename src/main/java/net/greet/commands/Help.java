package net.greet.commands;

import net.greet.input.Input;
import net.greet.Command;
import net.greet.data.GreetingColor;

public class Help implements Command {

    public String executeCommand( Input input ) {
        return "==================================================================" +
                "\nEnter one of these valid commands below:\n" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreet [name] [language] "+ GreetingColor.RESET+"- Greets a user in preferred language" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreeted "+ GreetingColor.RESET+"- Displays a list of all users that were greeted and number of they have been greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tgreeted [name] "+ GreetingColor.RESET+"- number of times a user was greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tcounter "+ GreetingColor.RESET+"- Displays the total number of users that were greeted" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tclear [name] "+ GreetingColor.RESET+"- clears user from database" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\tclear "+ GreetingColor.RESET+"- removes all users from database" +
                GreetingColor.GREEN_BOLD_BRIGHT +"\n\thelp "+ GreetingColor.RESET+"- shows list of available commands" +
                "\n================================================================" ;
    }
}
