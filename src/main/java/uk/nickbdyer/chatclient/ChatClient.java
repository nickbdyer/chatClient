package uk.nickbdyer.chatclient;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ChatClient {

    private Socket socket;
    private PrintStream output;

    public ChatClient(Socket socket, OutputStream output) {
        this.socket = socket;
        this.output = new PrintStream(output);
    }


    public void sendMessage(String message) {
        output.println(message);
    }
}

