package net.greet;

import net.greet.enums.Language;
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
    void testGreetAfrikaansMethod(){
        Greeter g = new Greeter();
        assertEquals("Goeie dag, Yaanie",g.greet("Yaanie", Language.AFRIKAANS));
    }

    @Test
    void testGreetEnglishMethod(){
        Greeter g = new Greeter();
        assertEquals("Hello, Yaanie",g.greet("Yaanie", Language.ENGLISH));
    }

    @Test
    void testGreetXhosaMethod(){
        Greeter g = new Greeter();
        assertEquals("Mholo, Yaanie",g.greet("Yaanie", Language.XHOSA));
    }

    @Test
    void testGreetFrenchMethod(){
        Greeter g = new Greeter();
        assertEquals("Bonjour, Yaanie",g.greet("Yaanie", Language.FRENCH));
    }

    @Test
    void testGreetGermanMethod(){
        Greeter g = new Greeter();
        assertEquals("Hallo, Yaanie",g.greet("Yaanie", Language.GERMAN));
    }

    @Test
    void testGreetDutchMethod(){
        Greeter g = new Greeter();
        assertEquals("Hallo, Yaanie",g.greet("Yaanie", Language.DUTCH));
    }

    @Test
    void testGreetArabicMethod(){
        Greeter g = new Greeter();
        assertEquals("Yaanie,مرحبا،",g.greet("Yaanie", Language.ARABIC));
    }

}
