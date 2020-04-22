package net.greet.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    @Test
    void testGreetingConstructor(){
        Greeting g = new Greeting("Hello, Michael", true);
        assertEquals(true,g instanceof Greeting);
    }


    @Test
    void testGetMessageGreeting(){
        Greeting g = new Greeting("Hello, Michael", true);
        assertEquals("Hello, Michael",g.getMessage());
    }

    @Test
    void testShowPromptGreeting(){
        Greeting g = new Greeting("Hello, Michael", true);
        assertEquals(true,g.showPrompt());
    }
}
