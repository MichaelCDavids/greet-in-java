package net.greet.utilities;

import net.greet.enumerators.LanguageType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreeterTest {

    @Test
    void testGreeterConstructor(){
        Greeter g = new Greeter();
        assertTrue(g instanceof Greeter);
    }

    @Test
    void testGreetMethod(){
        Greeter g = new Greeter();
        assertEquals("Goeie dag, Michael",g.greet("Michael", LanguageType.AFRIKAANS));
    }


}
