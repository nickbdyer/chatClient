package uk.nickbdyer.chatclient;

import java.io.*;

public class ChatClient {

    private BufferedReader input;
    private PrintStream output;

    public ChatClient(InputStream input, OutputStream output) {
        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = new PrintStream(output);
    }

    public void chat() {
        try {
            String message;
            while ((message = input.readLine()) != null) {
                output.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

