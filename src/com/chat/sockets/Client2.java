package com.chat.sockets;

import java.io.*;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) {
        Client2 client = new Client2();

    }

    public Client2() {
        try (Socket socket = new Socket("192.168.1.33", 5000)) {

            while(true) {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out.writeUTF("Client2: Sending message");
                System.out.println(in.readUTF());

            }





        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
