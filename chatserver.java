import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started. Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(
                clientSocket.getOutputStream(), true);

            BufferedReader serverInput = new BufferedReader(
                new InputStreamReader(System.in));

            String messageFromClient;

            while ((messageFromClient = input.readLine()) != null) {
                System.out.println("Client: " + messageFromClient);
                System.out.print("You: ");
                String response = serverInput.readLine();
                output.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
