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
            default:
                return "Hi";
        }
    }

}
