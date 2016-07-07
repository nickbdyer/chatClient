package uk.nickbdyer.chatclient;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    @Test
    public void returnsPortNumberIfPresent() {
        int portNumber = new Validator(new String[]{"localhost", "5555"}).getPort();
        assertEquals(5555, portNumber);
    }

    @Test
    public void returnsDefaultPortNumberIfNotPresent() {
        int portNumber = new Validator(new String[]{}).getPort();
        assertEquals(4444, portNumber);
    }

    @Test(expected = RuntimeException.class)
    public void advisesUserToPassPortAsNumberIfTheyPassAlphabeticalCharacters() {
        new Validator(new String[]{"localhost", "abc"}).getPort();
    }

    @Test(expected = RuntimeException.class)
    public void throwsRuntimeExceptionForOneArgument() {
        new Validator(new String[]{"localhost"});
    }

    @Test
    public void returnsHostNameIfPresent() {
        String hostName = new Validator(new String[]{"www.example.com", "5555"}).getHost();
        assertEquals("www.example.com", hostName);
    }

    @Test
    public void returnsAnotherHostNameIfPresent() {
        String hostName = new Validator(new String[]{"www.google.com", "5555"}).getHost();
        assertEquals("www.google.com", hostName);
    }

    @Test
    public void returnsDefaultHostNameIfNotPresent() {
        String hostName = new Validator(new String[]{}).getHost();
        assertEquals("localhost", hostName);
    }

}
