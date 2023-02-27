package com.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    private JPanel panel;
    private JTextField serverText;
    private JButton sendbtn;
    private JTextArea textArea;
    private JTextField chatText;
    private JButton connectButton;
    private JPanel panelHeader;
    private JPanel panelUsers;
    private JLabel labelServer;
    private JTextArea textAreaUsers;
    private JLabel nickname;

    public MainView() {
        this.openPanelOption();
        JFrame frame = new JFrame("first window");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.sendButton();
        this.connectButton();


    }

    public void openPanelOption() {
        Object[] options1 = { "Create a new room", "Join to room " };

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter your Nickname"));
        JTextField textField = new JTextField(10);
        panel.add(textField);

        int result = JOptionPane.showOptionDialog(null, panel, "Enter your nickname",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options1, null);

        if (result == JOptionPane.YES_OPTION){
            panelHeader.setVisible(false);
            connectButton.setText("Start Server");
            textAreaUsers.append(textField.getText());


        }
        if (result == JOptionPane.NO_OPTION) {
            System.out.println("room");
        }
    }

    public void sendButton() {
        sendbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Send button clicked!");

            }
        });

    }

    public void connectButton() {
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(connectButton.getText().equals("Start Server")) System.out.println("START SERVER!");
                if(connectButton.getText().equals("Connect")) System.out.println("Connect to SERVER!");

            }
        });
    }


}
