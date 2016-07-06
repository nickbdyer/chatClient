package uk.nickbdyer.chatclient;

import java.io.*;

public class ChatClient {

    private BufferedReader input;
    private PrintStream output;

    public ChatClient(OutputStream output) {
        this.output = new PrintStream(output);
    }

    public ChatClient(InputStream input, OutputStream output) {
        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = new PrintStream(output);
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    public void sendMessage() {
        try {
            output.println(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

