package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

public class Echoer extends Thread{

    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }


    // no try with resources because the method doesn't create the socket when the server connects to a client
    // so need to explicitly close it

    @Override
    public void run() {
        try {
            //Input stream from info coming in - wrapped in bufferedreader
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //Output stream for info going out - wrapped in a printwriter
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);   // If not true, have to call the flush method after every write to the stream to check if sent

            while(true) {
                String echoString = input.readLine();   // bufferedreader readline()
                System.out.println("Received client input: " + echoString);
                if(echoString.equals("exit")) {
                    break;
                }
//                try{
//                    Thread.sleep(15000);
//                } catch (InterruptedException e) {
//                    System.out.println("Thread interrupted");
//                }
                output.println("Echo from server: " + echoString);  // echo string back to the client and writing string to the socket (output)
            }
        } catch(IOException e) {
            System.out.println("Oops: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket did not close");
            }
        }
    }
}

