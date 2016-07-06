package uk.nickbdyer.chatclient;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertTrue;

public class ChatClientTest {

    @Test
    public void clientCanConnectToServerSocket() throws IOException {
        new ServerSocket(4444);

        Socket clientSocket = new ChatClient("localhost", 4444).connect();

        assertTrue(clientSocket.isConnected());
    }

    @Test
    public void clientCanConnectToAnotherServer() throws IOException {
        new ServerSocket(5555);

        Socket clientSocket = new ChatClient("localhost", 5555).connect();

        assertTrue(clientSocket.isConnected());
    }
}
