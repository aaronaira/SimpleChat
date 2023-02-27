package com.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {
        Thread socketLoop = new Thread(this);
        socketLoop.start();
    }

    @Override
    public void run() {

        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port: " + port);

            ArrayList<Socket> clients = new ArrayList<>();
            String message;

            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                message = in.readUTF();

                for (Socket client: clients) {
                    System.out.printf("Sending message to client: %s%n", client.getInetAddress().getHostAddress());
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());
                    out.writeUTF(message);
                }


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}