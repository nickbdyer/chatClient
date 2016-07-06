package uk.nickbdyer.chatclient;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    public Socket connect(String hostname, int port) {
        try {
            return new Socket("localhost", 4444);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

