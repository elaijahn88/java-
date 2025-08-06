import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connected to server.");

            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

            BufferedReader clientInput = new BufferedReader(
                new InputStreamReader(System.in));

            Thread sendThread = new Thread(() -> {
                try {
                    String userInput;
                    while ((userInput = clientInput.readLine()) != null)
