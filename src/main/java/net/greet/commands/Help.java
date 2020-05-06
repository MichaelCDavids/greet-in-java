package net.greet.commands;

import net.greet.input.Input;
import net.greet.interfaces.CommandInterface;
import net.greet.theme.ConsoleColors;

public class Help implements CommandInterface {

    public String executeCommand( Input input ) {
        return "==================================================================" +
                "\nEnter one of these valid commands below:\n" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tgreet [name] [language] "+ConsoleColors.RESET+"- Greets a user in preferred language" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tgreeted "+ConsoleColors.RESET+"- Displays a list of all users that were greeted and number of they have been greeted" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tgreeted [name] "+ConsoleColors.RESET+"- number of times a user was greeted" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tcounter "+ConsoleColors.RESET+"- Displays the total number of users that were greeted" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tclear [name] "+ConsoleColors.RESET+"- clears user from database" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\tclear "+ConsoleColors.RESET+"- removes all users from database" +
                ConsoleColors.GREEN_BOLD_BRIGHT +"\n\thelp "+ConsoleColors.RESET+"- shows list of available commands" +
                "\n================================================================" ;
    }
}
