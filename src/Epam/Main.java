package Epam;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int port = 7080;
        try {
            InetAddress address = InetAddress.getByName("vm2.skycelot.ru");
            Socket client = new Socket(address,port);

            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            InputStreamReader fromKeyboard = new InputStreamReader(System.in);
            InputStreamReader fromServer = new InputStreamReader(in);
            int i = 0;
            byte[] temp = new byte[256];
            while ((temp[i++] = (byte) fromKeyboard.read()) != '\n');
            byte[] toOutMessage;
            toOutMessage = temp;
            temp = new byte[256];
            out.write(toOutMessage);
            out.flush();
            i = 0;
            while ((temp[i] = (byte)fromServer.read()) != '\n'){
                System.out.println(temp[i]);
                i++;
            }
            byte[] inMessage;
            inMessage = temp;
            String line = new String(inMessage, UTF_8);
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
