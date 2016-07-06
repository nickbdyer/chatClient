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

        Socket clientSocket = new ChatClient().connect("localhost", 4444);

        assertTrue(clientSocket.isConnected());
    }
}
