package org.java2.lesson6.homeWork;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client implements Runnable{
    private final String SERVER_ADDRESS = "localhost";
    private final int SERVER_PORT = 8981;
    private Socket socket;
    public BufferedReader reader;
    public BufferedWriter writer;
    JTextArea textArea;

    public Client(BufferedReader reader, JTextArea textArea) throws IOException {
        this.socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.reader = reader;
        this.textArea = textArea;
        this.writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    @Override
    public void run() {
        while (true){
            try {
                String str = reader.readLine();
                if (reader.readLine() == null) break;
                if (str.equalsIgnoreCase("end")) break;
                textArea.append(str);
                textArea.append(Window.LINE_SEPARATOR);

            } catch (IOException e) {
            }
        }
    }
    public void end(){
        try {
            this.writer.write("end");
            this.writer.flush();
            this.socket.close();
            this.writer.close();
            this.reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
