package com.chat;

import com.chat.view.MainView;
import com.chat.sockets.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        MainView mainView = new MainView(server);




    }
}
