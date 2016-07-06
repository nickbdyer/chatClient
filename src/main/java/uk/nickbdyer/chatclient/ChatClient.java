package uk.nickbdyer.chatclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ChatClient {

    private PrintStream output;

    public ChatClient(Socket socket) {
        try {
            this.output = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }
}

