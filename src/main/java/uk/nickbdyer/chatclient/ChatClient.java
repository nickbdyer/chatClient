package uk.nickbdyer.chatclient;

public class ChatClient {

}

//public class EchoClient {
//    public static void main(String[] args) throws IOException {
//
//        if (args.length != 2) {
//            System.err.println(
//                    "Usage: java EchoClient <host name> <port number>");
//            System.exit(1);
//        }
//
//        String hostName = args[0];
//        int portNumber = Integer.parseInt(args[1]);
//
//        try (
//                Socket echoSocket = new Socket(hostName, portNumber);
//                PrintWriter out =
//                        new PrintWriter(echoSocket.getOutputStream(), true);
//                BufferedReader stdIn =
//                        new BufferedReader(
//                                new InputStreamReader(System.in))
//        ) {
//            String userInput;
//            while ((userInput = stdIn.readLine()) != null) {
//                out.println(userInput);
//            }
//        } catch (UnknownHostException e) {
//            System.err.println("Don't know about host " + hostName);
//            System.exit(1);
//        } catch (IOException e) {
//            System.err.println("Couldn't get I/O for the connection to " +
//                    hostName);
//            System.exit(1);
//        }
//    }
//}