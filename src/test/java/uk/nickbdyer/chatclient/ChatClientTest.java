package uk.nickbdyer.chatclient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertTrue;

public class ChatClientTest {

    private ServerSocket server;

    @Before
    public void setUp() throws IOException {
        server = new ServerSocket(4444);
    }

    @After
    public void tearDown() throws IOException {
        server.close();
    }

    @Test
    public void clientCanConnectToServerSocket() throws IOException {
        Socket clientSocket = new ChatClient("localhost", 4444).connect();

        assertTrue(clientSocket.isConnected());
    }

    @Test(expected = RuntimeException.class)
    public void ifThereIsNoServerRunningAtTheHostAndPortGivenAnExceptionWillBeThrown() throws IOException {
        Socket clientSocket = new ChatClient("localhost", 5555).connect();

        assertTrue(clientSocket.isConnected());
    }
}
