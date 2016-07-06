package uk.nickbdyer.chatclient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ChatClient {

    private PrintStream output;

    public ChatClient(OutputStream output) {
        this.output = new PrintStream(output);
    }

    public void sendMessage(String message) {
        output.println(message);
    }
}

