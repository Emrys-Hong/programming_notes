package Week5;
import java.net.*;
import java.io.*;
 
public class EchoServer {
    public static void main(String[] args) throws Exception {
    	ServerSocket serverSocket = new ServerSocket(4321);
    	System.out.println("(... expecting connection ...)");
        Socket clientSocket = serverSocket.accept();     
    	System.out.println("(... connection established ...)");
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
        String inputLine;
        while (!((inputLine = in.readLine()).equals("Bye"))) {
        	System.out.println("Wife says:" + inputLine);
            out.println(stdIn.readLine());
            out.flush();
        }
        out.println(inputLine);            
        serverSocket.close();
        clientSocket.close();
        out.close();
        in.close();
    }
}