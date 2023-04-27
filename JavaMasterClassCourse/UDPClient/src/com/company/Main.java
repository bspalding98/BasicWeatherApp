package com.company;

//handshaking must take place in TCP
    // sends a requests, sever sends a response
// also performs error checking
// need overhead which can be bad

// UDP though
// no handshaking
// server doesn't send response either
// so if you require a response from the server, wouldn't use UDP
// USE WHEN
    // don't need a reliable connect
    // two-way connection
    // or speed it crucial

// uses datagram - self contained message, and not guarenteed to get to destination
// Used when you want speed and if maybe you lose a few and it wouldn't matter
    //EG voice override skype because speed is more important and if a packet isn't received you normally wouldn't notice when watching a video
    // and once data gets it, it overrides all the other data, so not bad if it doesn't get there sometime

// So protocol between UDP and TCP just depends on program

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();   // getting localhost because running it on my own machine.  // getByName() - this allows you to pass a hostname and get the Inet Add for it
            DatagramSocket datagramSocket = new DatagramSocket();   // create socket to use - not associated with a port number because there is no communication

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter string to be echoed: " );
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);   // creating packet - self contained message, contains address and port number, if server wants to respond. datagram has everything needed
                datagramSocket.send(packet);    // sending to server

                // This is used to get response from server in UDP
                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));

            } while(!echoString.equals("exit"));

        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch(IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

