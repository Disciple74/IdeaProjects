package ru.geekbrains.tasks.ed.art.Task_6;

import java.io.*;

public class Combination {
    public static void main (String args[]){
        Combination();

        try {
            Reader reader = new FileReader("src/text/text3.txt");
            int read;
            while((read = reader.read()) != -1)
            System.out.print((char)read);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void Combination (){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int read;
        try{
            inputStream = new FileInputStream("src/text/text1.txt");
            outputStream = new FileOutputStream("src/text/text3.txt");
            while((read = inputStream.read())!=-1) outputStream.write(read);
            inputStream.close();
            inputStream = new FileInputStream("src/text/text2.txt");
            while((read = inputStream.read())!=-1) outputStream.write(read);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.flush();
                } catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    outputStream.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}


