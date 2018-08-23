package org.java2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame{

    toTextFile logger;

    private JTextArea messageBox;
    private JTextField writeMessageBox;
    private JButton sendButton;

    public Chat(toTextFile logger) throws HeadlessException{
        this.logger = logger;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Messenger");
        setSize(400,500);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());
        messageBox = new JTextArea();
        messageBox.setFont(new Font("Arial", Font.PLAIN, 15));
        messageBox.setLineWrap(true);
        messageBox.setWrapStyleWord(true);
        JScrollPane jScrollPane = new JScrollPane(messageBox);
        jPanel1.add(jScrollPane);
        add(jPanel1, BorderLayout.CENTER);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));
        writeMessageBox = new JTextField();
        writeMessageBox.setFont(new Font("Arial", Font.PLAIN, 15));
        sendButton = new JButton("Send");
        jPanel2.add(writeMessageBox);
        jPanel2.add(sendButton);
        add(jPanel2, BorderLayout.SOUTH);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                sendText();
            }
        });
        writeMessageBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                sendText();
            }
        });



    }

    private void sendText(){
        String message = writeMessageBox.getText();
        if (!message.isEmpty()){
            messageBox.append(message);
            messageBox.append(toTextFile.LINE_SEPARATOR);
            logger.println(message);
            writeMessageBox.setText("");
        }
    }
}
