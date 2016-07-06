package uk.nickbdyer.chatclient;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    private String hostName;
    private int portNumber;

    public ChatClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public Socket connect() {
        try {
            return new Socket(hostName, portNumber);
        } catch (IOException e) {
            throw new RuntimeException("Could not connect to ServerSocket.");
        }
    }
}

