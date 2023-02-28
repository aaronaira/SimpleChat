package com.chat.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    public ServerSocket serverSocket;
    public Socket clientSocket;
    DataInputStream in;
    DataOutputStream out;

    public Server() {

    }

    public void initServer() {
        Thread socketLoop = new Thread(this);
        socketLoop.start();

    }



    @Override
    public void run() {

        int port = 5000;

        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            ArrayList<Socket> clients = new ArrayList<>();
            String message;


            while (true) {
                this.clientSocket = this.serverSocket.accept();
                clients.add(this.clientSocket);
                in = new DataInputStream(this.clientSocket.getInputStream());
                message = in.readUTF();

                for (Socket client: clients) {
                    System.out.printf("Sending message to client: %s%n", client.getInetAddress().getHostAddress());
                    out = new DataOutputStream(client.getOutputStream());
                    out.writeUTF(message);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
/*
*
* */

}