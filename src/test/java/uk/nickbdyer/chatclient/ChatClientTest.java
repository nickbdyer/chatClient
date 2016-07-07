package uk.nickbdyer.chatclient;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class ChatClientTest {

    private ServerSocket server;
    private OutputStream outContent;
    private MockSocket mockSocket;

    @Before
    public void setUp() throws IOException {
        server = new ServerSocket(4444);
        outContent = new ByteArrayOutputStream();
        mockSocket = new MockSocket(outContent);
    }

    @After
    public void tearDown() throws IOException {
        server.close();
        outContent.close();
        mockSocket.close();
    }

    @Test
    public void clientCanSendLessThanNoMessageToServerSocket() throws IOException {
        InputStream in = new ByteArrayInputStream("".getBytes());
        ChatClient client = new ChatClient(in, mockSocket.getOutputStream());
        client.chat();
        assertEquals("", outContent.toString());
    }

    @Test
    public void clientCanSendNoMessageToServerSocket() throws IOException {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        ChatClient client = new ChatClient(in, mockSocket.getOutputStream());
        client.chat();
        assertEquals("\n", outContent.toString());
    }

    @Test
    public void clientCanSendHelloMessageToServerSocket() throws IOException {
        InputStream in = new ByteArrayInputStream("Hello".getBytes());
        ChatClient client = new ChatClient(in, mockSocket.getOutputStream());
        client.chat();
        assertEquals("Hello\n", outContent.toString());
    }

    @Test
    public void clientCanSendGoodByeMessageToServerSocket() throws IOException {
        InputStream in = new ByteArrayInputStream("GoodBye".getBytes());
        ChatClient client = new ChatClient(in, mockSocket.getOutputStream());
        client.chat();
        assertEquals("GoodBye\n", outContent.toString());
    }

    @Test
    public void clientCanSendMultipleMessagesToServerSocket() throws IOException {
        InputStream in = new ByteArrayInputStream("Hello\nGoodBye".getBytes());
        ChatClient client = new ChatClient(in, mockSocket.getOutputStream());
        client.chat();
        assertEquals("Hello\nGoodBye\n", outContent.toString());
    }

    @Test(expected = RuntimeException.class)
    public void clientWillThrowRuntimeExceptionIfItCannotReadTheStream() {
        InputStream in = new UnReadableInputStream();
        ChatClient client = new ChatClient(in, mockSocket.getOutputStream());
        client.chat();
    }

}
