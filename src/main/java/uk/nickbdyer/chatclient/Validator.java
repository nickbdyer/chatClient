package uk.nickbdyer.chatclient;

public class Validator {

    private String[] args;

    public Validator(String[] args) {
        this.args = args;
        if (args.length != 2 && args.length != 0) {
            throw new RuntimeException("Incorrect number of arguments provided");
        }
    }

    public Integer getPort() {
        if(args.length == 0) return 4444;
        try {
            return Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect Port Format");
        }
    }

    public String getHost() {
        if(args.length == 0) return "localhost";
        return args[0];
    }

}
