package org.java2.lesson4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class toTextFile {

    private FileWriter writer;

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public toTextFile(File file) throws IOException{
        this.writer = new FileWriter(file, true);
    }

    public void println(Object o){
        try{
            this.writer.append(o.toString());
            this.writer.append(LINE_SEPARATOR);
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
