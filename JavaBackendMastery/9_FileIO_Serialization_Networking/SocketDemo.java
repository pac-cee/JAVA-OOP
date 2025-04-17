// Demonstrates a simple client-server socket communication
import java.io.*;
import java.net.*;
// Server
class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server waiting for client...");
        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = in.readLine();
        System.out.println("Received: " + msg);
        in.close(); socket.close(); server.close();
    }
}
// Client
class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello Server!");
        out.close(); socket.close();
    }
}
