package ru.rrr.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.rrr.service.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@Component
public class TCPServer {

    public void startServer(ConfigurableApplicationContext context) {
        ServerSocket servers = null;
        Socket fromclient;
        try {
            servers = new ServerSocket(4444);
        } catch (IOException e) {
            log.info("Couldn't listen to port 4444");
            System.exit(-1);
        }
        while (true) {
            try {
                log.info("Waiting for a new client...");
                fromclient = servers.accept();
                Socket finalFromclient = fromclient;

                Thread thread = new Thread(() -> runClient(context, finalFromclient));
                thread.setDaemon(true);
                thread.start();

                log.info("Current client connected");
                if (servers.isClosed()) {
                    servers = new ServerSocket(4444);
                }
            } catch (IOException e) {
                log.info("Can't accept");
                System.exit(-1);
            }
        }
    }

    private void runClient(ConfigurableApplicationContext context, Socket fromclient) {
        while (true) {
            try {
                InputStream inputStream = fromclient.getInputStream();
                OutputStream outputStream = fromclient.getOutputStream();
                byte[] buf = new byte[64 * 1024];
                int r = inputStream.read(buf);
                String data = new String(buf, 0, r);
                log.info("Data from client: \n" + data);
                String response = context.getBean(Handler.class).handleMessage(data);
                final int lengthMessage = String.valueOf(response).getBytes().length;
                log.info("length of message: " + lengthMessage);
                outputStream.write(String.valueOf(response).getBytes());
                log.info("Response from simulator KZTA: \n" + response);
            } catch (Exception e) {
                log.info("Current client disconnected");
                log.info(e.toString());
                break;
            }
        }
    }
}
