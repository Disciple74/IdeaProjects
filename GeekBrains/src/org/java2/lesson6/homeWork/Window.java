package org.java2.lesson6.homeWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;

public class Window extends JFrame {
    private JTextArea output;
    private JTextField input;
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private Client client;
    private BufferedReader reader;

    public Window() throws IOException {
        setBounds(600,300,500,500);
        setTitle("Client");
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        output = new JTextArea();
        output.setLineWrap(true);
        output.setEditable(false);
        output.setWrapStyleWord(true);
        output.setFont(new Font("Arial", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(output);
        add(scrollPane, BorderLayout.CENTER);
        JPanel inputPanel = new JPanel(new BorderLayout());
        add(inputPanel, BorderLayout.SOUTH);
        JButton send = new JButton("Send");
        inputPanel.add(send, BorderLayout.EAST);
        input = new JTextField();
        input.setFont(new Font("Arial", Font.PLAIN, 15));
        inputPanel.add(input, BorderLayout.CENTER);
        this.client = new Client(reader, output);
        Thread thread = new Thread(client);
        thread.start();
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!input.getText().trim().isEmpty()) {
                    if (!input.getText().equalsIgnoreCase("end")) {
                        sendMessage();
                        input.grabFocus();
                    } else try {
                        exit();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!input.getText().trim().isEmpty()) {
                    if (!input.getText().equalsIgnoreCase("end")) {
                        sendMessage();
                    } else try {
                        exit();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                input.grabFocus();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                try {
                    exit();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        setVisible(true);
    }
    private void exit() throws IOException {
        client.end();
        System.exit(0);
        input.setText("");
    }

    private void sendMessage(){
        try {
            client.writer.write(input.getText());
            client.writer.newLine();
            client.writer.flush();
            input.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
