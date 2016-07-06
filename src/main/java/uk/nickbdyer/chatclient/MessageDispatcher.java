package uk.nickbdyer.chatclient;

import java.io.InputStream;
import java.io.OutputStream;

public class MessageDispatcher {

    private InputStream input;
    private OutputStream output;

    public MessageDispatcher(InputStream inputStream, OutputStream outputStream) {
        this.input = inputStream;
        this.output = outputStream;

    }

    public void sendInputToOutput() {

    }
}
