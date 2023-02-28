package com.chat.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client3 {

    public static void main(String[] args) {
        Client3 client = new Client3();

    }

    public Client3() {
        try (Socket socket = new Socket("192.168.1.33", 5000)) {

            while(true) {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out.writeUTF("Client3: Sending message");
                System.out.println(in.readUTF());

            }





        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
