package org.java2.lesson2;

import java.util.ArrayList;

public class MyException extends Exception {
    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause);
    }
}
