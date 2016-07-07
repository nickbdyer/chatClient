package uk.nickbdyer.chatclient;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Validator validator = new Validator(args);
        new ChatClient(System.in, new Socket(validator.getHost(), validator.getPort()).getOutputStream()).chat();
    }
}
