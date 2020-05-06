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
    void testGreetAfrikaansMethod(){
        Greeter g = new Greeter();
        assertEquals("Goeie dag, Yaanie",g.greet("Yaanie", LanguageType.AFRIKAANS));
    }

    @Test
    void testGreetEnglishMethod(){
        Greeter g = new Greeter();
        assertEquals("Hello, Yaanie",g.greet("Yaanie", LanguageType.ENGLISH));
    }

    @Test
    void testGreetXhosaMethod(){
        Greeter g = new Greeter();
        assertEquals("Mholo, Yaanie",g.greet("Yaanie", LanguageType.XHOSA));
    }

    @Test
    void testGreetFrenchMethod(){
        Greeter g = new Greeter();
        assertEquals("Bonjour, Yaanie",g.greet("Yaanie", LanguageType.FRENCH));
    }

    @Test
    void testGreetGermanMethod(){
        Greeter g = new Greeter();
        assertEquals("Hallo, Yaanie",g.greet("Yaanie", LanguageType.GERMAN));
    }

    @Test
    void testGreetDutchMethod(){
        Greeter g = new Greeter();
        assertEquals("Hallo, Yaanie",g.greet("Yaanie", LanguageType.DUTCH));
    }

    @Test
    void testGreetArabicMethod(){
        Greeter g = new Greeter();
        assertEquals("Yaanie,مرحبا،",g.greet("Yaanie", LanguageType.ARABIC));
    }

}
