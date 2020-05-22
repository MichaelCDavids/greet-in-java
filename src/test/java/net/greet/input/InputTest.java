package net.greet.input;

import net.greet.enums.Command;
import net.greet.enums.Language;
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
        assertEquals(Command.GREET,i.getCommandType());
    }
    @Test
    void testGetEnteredLanguageType(){
        Input i = new Input("greet Michael English");
        assertEquals(Language.ENGLISH,i.getEnteredLanguage());
    }

}
