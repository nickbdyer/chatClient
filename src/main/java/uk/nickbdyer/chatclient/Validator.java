package uk.nickbdyer.chatclient;

public class Validator {

    public static Integer getPort(String[] args) {
        if(args.length != 2) return 4444;
        try {
            return Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect Port Format");
        }
    }

}
