package org.java2.lesson4;

import java.io.File;

public class App {
    public static void main(String[] args) throws Exception{
        File resourcesDir = new File(App.class.getClassLoader().getResource("").toURI());
        File logDir = new File(resourcesDir, "log");
        File loggerFile = new File(logDir, "client.log");
        if (!logDir.exists()){
            logDir.mkdir();
        }
        if (!loggerFile.exists()){
            loggerFile.createNewFile();
        }
        toTextFile logger = new toTextFile(loggerFile);
        Chat form = new Chat(logger);
        form.setVisible(true);

    }
}
