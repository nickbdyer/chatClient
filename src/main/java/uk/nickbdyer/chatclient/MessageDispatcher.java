package uk.nickbdyer.chatclient;

import java.io.*;

public class MessageDispatcher {

    private BufferedReader input;
    private PrintStream output;

    public MessageDispatcher(InputStream inputStream, OutputStream outputStream) {
        this.input = new BufferedReader(new InputStreamReader(inputStream));
        this.output = new PrintStream(outputStream);
    }

    public void sendInputToOutput() {
        String message;
        try {
            if ((message = input.readLine()) != null) {
                output.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
