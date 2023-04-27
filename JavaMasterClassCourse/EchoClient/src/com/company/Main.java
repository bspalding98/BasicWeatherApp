package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

// do not need try with resources or manually close buffered reader and
// printwrite because when the socket is closed, it closes
// the underlying streams

public class Main {

    public static void main(String[] args) {
        // localhost means we want to connect to the server running on the same host
        // Which is our computer
        // Also need to use the same port number than server
            // also IP is 127.0.0.1
        try(Socket socket = new Socket("localhost", 5000)) {    // address of host and port number
            socket.setSoTimeout(5000);  // this could be if the server is done or something, so have a timeout period so client is just waiting
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            // could hardcode string
            // but will ask instead
            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;
            do {
                System.out.println("Enter String to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);   // sends to server
                if (!echoString.equals("exit")) {    // see if string equals exit, if so terminate
                    response = echoes.readLine();   // read data coming back from server
                    System.out.println(response);   // printing what we got
                }
            } while (!echoString.equals("exit"));
        }catch (SocketTimeoutException e) {
            System.out.println("The socket timed out");
        }catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}
