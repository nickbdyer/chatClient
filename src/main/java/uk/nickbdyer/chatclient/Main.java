package uk.nickbdyer.chatclient;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        new ChatClient(System.in, new Socket("localhost", Validator.getPort(args)).getOutputStream()).chat();
    }
}
