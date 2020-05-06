package net.greet.utilities;

import net.greet.enumerators.LanguageType;

public class Greeter{

    public String greet(String userName, LanguageType languageType){
        switch (languageType){
            case ENGLISH:
                return "Hello, "+userName;
            case AFRIKAANS:
                return "Goeie dag, "+userName;
            case XHOSA:
                return "Mholo, "+userName;
            case ARABIC:
                return userName+",مرحبا،";
            case FRENCH:
                return "Bonjour, "+userName;
            case ITALIAN:
                return "Ciao, "+userName;
            case GERMAN:
            case DUTCH:
                return "Hallo, "+userName;
            default:
                return "Hi";
        }
    }

}
