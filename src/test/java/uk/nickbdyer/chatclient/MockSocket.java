package uk.nickbdyer.chatclient;

import java.io.OutputStream;
import java.net.Socket;

public class MockSocket extends Socket {

    private OutputStream output;

    public MockSocket(OutputStream output) {
        this.output = output;
    }

    @Override
    public OutputStream getOutputStream() {
        return output;
    }
}
