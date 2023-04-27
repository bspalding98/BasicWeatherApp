package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//multiple threaded server - so multiple people can connect

// do not need try with resources or manually close buffered reader and
// printwrite because when the serversocket is closed, it closes
// the underlying streams

public class Main {

    public static void main(String[] args) {

        // Way to find out if used or reserved, can try just test to see if it works.
        try (ServerSocket serverSocket = new ServerSocket(5000)) {  // port number can be between (int) 0 and 65535 inclusive - some could already be reserved or used

            // Server remains alive until the client doesn't need it anymore. so make it infinite
            // before only the readLine() and below were in while loop. put the rest in so multiple connections can be accepted.
            while(true) {
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
                // This is the above lines
                new Echoer(serverSocket.accept()).start();

                // Old way when no echoer class
//                // Block until a client connect to the server
//                Socket socket = serverSocket.accept();  // socket instance - used to connect to the client
//                System.out.println("Client connected");
            }

        }catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
