package com.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        InputStream iis = socket.getInputStream();
        OutputStream oos = socket.getOutputStream();
        oos.write("Hello!".getBytes());
    }
}
