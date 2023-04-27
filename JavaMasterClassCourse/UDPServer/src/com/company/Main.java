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
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            while(true) {
                byte[] buffer = new byte[50];   // accept data from the socket
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);  // create the datagram socket itself and populate with whatever is received - buffer.length stops null entries being printed in byte array if not all used up
                // No end to end connection, so doesn't use anything to communicate with the client
                socket.receive(packet); // to fill the packet with the content  - blocked until received
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));

                // THis is used to send response to client in UDP
                String returnString = "echo: " + new String(buffer, 0, packet.getLength());
                byte[] buffer2 = returnString.getBytes();   // can use same array, this is for clarity
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                socket.send(packet);
            }

        } catch(SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
