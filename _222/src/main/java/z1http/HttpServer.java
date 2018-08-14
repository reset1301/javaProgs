package z1http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Обрабатывает запросы от клиентов, возвращая файлы, указанные
 * в url-path или ответ с кодом 404, если такой файл не найден.
 */
public class HttpServer {
    private static int min;
    private static final int DEFAULT_PORT = 8081;
    static int max;


    /**
     * Первым аргументом может идти номер порта.
     */
    public static void main(String[] args) {
        serverRun(args);
    }

    public static void serverRun(String[] args) {
        /* Если аргументы отсутствуют, порт принимает значение поумолчанию */
        int port = DEFAULT_PORT;
//        -------------
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
//        } else if (args.length == 2) {
//            ip = args[0];
//            port = Integer.parseInt(args[1]);
        } else if (args.length == 3) {
//            ip = args[0];
            port = Integer.parseInt(args[0]);
            min = Integer.parseInt(args[1]);
            max = Integer.parseInt(args[2]);
        } else {
            min = 0;
            max = 41943040;
        }
//        --------------
        /* Создаем серверный сокет на полученном порту */
        ServerSocket serverSocket = null;
        try {
//            ServerSocketFactory ssocketFactory = SSLServerSocketFactory.getDefault();
//            serverSocket = ssocketFactory.createServerSocket(port);
//            serverSocket = new ServerSocket(port,1024,InetAddress.getByName("localhost"));
//            serverSocket = new ServerSocket(port, 1024, InetAddress.getByAddress(addr));
            serverSocket = new ServerSocket(port, 1024);
            System.out.println("Server started on port: "
                    + serverSocket.getLocalPort() + "\n");
        } catch (IOException e) {
            System.out.println("Port " + port + " is blocked.");
            e.printStackTrace();
            System.exit(-1);
        }
        /*
         * Если порт был свободен и сокет был успешно создан, можно переходить к
         * следующему шагу - ожиданию клиeнтов
         */
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                /* Для обработки запроса от каждого клиента создается
                 * отдельный объект и отдельный поток */
                ClientSession session = new ClientSession(clientSocket);
                new Thread(session).start();
            } catch (IOException e) {
                System.out.println("Failed to establish connection.");
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        }
    }
}
   