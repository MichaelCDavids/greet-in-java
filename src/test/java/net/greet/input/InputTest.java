package net.greet.input;

import net.greet.enumerators.CommandType;
import net.greet.enumerators.LanguageType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @Test
    void testInputConstructor(){
        Input i = new Input("greet Michael English");
        assertEquals(3,i.getArgumentsLength());
    }

    @Test
    void testGetEnteredName(){
        Input i = new Input("greet Michael English");
        assertEquals("Michael",i.getEnteredName());
    }
    @Test
    void testGetCommandType(){
        Input i = new Input("greet Michael English");
        assertEquals(CommandType.GREET,i.getCommandType());
    }
    @Test
    void testGetEnteredLanguageType(){
        Input i = new Input("greet Michael English");
        assertEquals(LanguageType.ENGLISH,i.getEnteredLanguage());
    }

}
