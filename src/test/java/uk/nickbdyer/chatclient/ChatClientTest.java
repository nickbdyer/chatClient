package uk.nickbdyer.chatclient;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ChatClientTest {

    private ServerSocket server;
    private OutputStream outContent;

    @Before
    public void setUp() throws IOException {
        server = new ServerSocket(4444);
        outContent = new ByteArrayOutputStream();
    }

    @After
    public void tearDown() throws IOException {
        server.close();
        outContent.close();
    }

    @Test
    public void clientCanSendHelloMessageToServerSocket() throws IOException {
        ChatClient client = new ChatClient(new Socket("localhost", 4444), outContent);
        client.sendMessage("Hello");
        assertEquals("Hello\n", outContent.toString());
    }

    @Test
    public void clientCanSendGoodByeMessageToServerSocket() throws IOException {
        ChatClient client = new ChatClient(new Socket("localhost", 4444), outContent);
        client.sendMessage("GoodBye");
        assertEquals("GoodBye\n", outContent.toString());
    }

    @Ignore //Test to be moved to validator when built
    @Test(expected = RuntimeException.class)
    public void ifThereIsNoServerRunningAtTheHostAndPortGivenAnExceptionWillBeThrown() throws IOException {
        ChatClient client = new ChatClient(new Socket("localhost", 5555), outContent);
    }

}
