package com.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{


    public Client() {
        Thread socketLoop = new Thread(this);
        socketLoop.start();
    }
    public static void main(String[] args) {
        Client client = new Client();


    }

    @Override
    public void run() {
        try (Socket socket = new Socket("192.168.1.33", 5000)) {


            while(true) {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                out.writeUTF("Client1: Sending message");
                System.out.println(in.readUTF());

            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
