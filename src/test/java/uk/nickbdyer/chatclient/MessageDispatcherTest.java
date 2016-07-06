package uk.nickbdyer.chatclient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MessageDispatcherTest {

    private OutputStream out;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
    }

    @After
    public void tearDown() throws IOException {
        out.close();
    }

    @Test
    public void outputsNothingWhenNothingIsSent() {
        InputStream in = new ByteArrayInputStream("".getBytes());
        MessageDispatcher dispatcher = new MessageDispatcher(in, out);

        dispatcher.sendInputToOutput();

        assertEquals("", out.toString());
    }



}
