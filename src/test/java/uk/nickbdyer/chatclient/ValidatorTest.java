package uk.nickbdyer.chatclient;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    @Test
    public void returnsPortNumberIfPresent() {
        int portNumber = Validator.getPort(new String[]{"localhost", "5555"});
        assertEquals(5555, portNumber);
    }

    @Test
    public void returnsDefaultPortNumberIfNotPresent() {
        int portNumber = Validator.getPort(new String[]{"localhost"});
        assertEquals(4444, portNumber);
    }

    @Test(expected = RuntimeException.class)
    public void advisesUserToPassPortAsNumberIfTheyPassAlphabeticalCharacters() {
        Validator.getPort(new String[]{"localhost", "abc"});
    }

}
