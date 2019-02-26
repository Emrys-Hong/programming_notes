package Week5;
import java.io.*;
import java.net.*;
 
public class EchoClient {
    public static void main(String[] args) throws Exception {
        String hostIP = "10.12.106.12"; //this should be the server 
        int portNumber = 4321;
 
		Socket echoSocket = new Socket();
		SocketAddress sockaddr = new InetSocketAddress(hostIP, portNumber);
		echoSocket.connect(sockaddr, 100);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
        String userInput;
        do {
            userInput = stdIn.readLine();
            out.println(userInput);
            out.flush();
            System.out.println("Husband says: " + in.readLine());
        } while (!userInput.equals("Bye"));
            
        echoSocket.close();
        in.close();
        out.close();
        stdIn.close();           
    }
}
