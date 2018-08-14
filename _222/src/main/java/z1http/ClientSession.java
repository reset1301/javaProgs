package z1http;


import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import static java.lang.Math.*;

/**
 * Обрабатывает запрос клиента.
 */
public class ClientSession implements Runnable {
    private Socket socket;
    private InputStream in = null;
    private OutputStream out = null;

    private static final String DEFAULT_FILES_DIR = "/www";
    public final static int length = 1024;

    @Override
    public void run() {
        try {
            /* Получаем заголовок сообщения от клиента */
            String header = readHeader();
            System.out.println(header + "\n");
            /* Получаем из заголовка указатель на интересующий ресурс */
            String url = getURIFromHeader(header);
            System.out.println("Resource: " + url + "\n");
            /* Отправляем содержимое ресурса клиенту */
            int code = send(url);
            System.out.println("Result code: " + code + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ClientSession(Socket socket) throws IOException {
        this.socket = socket;
        initialize();
    }

    private void initialize() throws IOException {
        /* Получаем поток ввода, в который помещаются сообщения от клиента */
        in = socket.getInputStream();
        /* Получаем поток вывода, для отправки сообщений клиенту */
        out = socket.getOutputStream();
    }

    /**
     * Считывает заголовок сообщения от клиента.
     *
     * @return строка с заголовком сообщения от клиента.
     * @throws IOException
     */
    private String readHeader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder builder = new StringBuilder();
        String ln = null;
        while (true) {
            ln = reader.readLine();
            if (ln == null || ln.isEmpty()) {
                break;
            }
            builder.append(ln + System.getProperty("line.separator"));
        }
        return builder.toString();
    }

    /**
     * Вытаскивает идентификатор запрашиваемого ресурса из заголовка сообщения от
     * клиента.
     *
     * @param header заголовок сообщения от клиента.
     * @return идентификатор ресурса.
     */
    private String getURIFromHeader(String header) {
        int from = header.indexOf(" ") + 1;
        int to = header.indexOf(" ", from);
        String uri = header.substring(from, to);
        int paramIndex = uri.indexOf("?");
        if (paramIndex != -1) {
            uri = uri.substring(0, paramIndex);
        }
        return DEFAULT_FILES_DIR + "/1.a";
//        return DEFAULT_FILES_DIR + uri;
//        return "//localhost/c$/111/2.a";
    }

    /**
     * Отправляет ответ клиенту. В качестве ответа отправляется http заголовок и
     * содержимое указанного ресурса. Если ресурс не указан, отправляется
     * перечень доступных ресурсов.
     *
     * @param url идентификатор запрашиваемого ресурса.
     * @return код ответа. 200 - если ресурс был найден, 404 - если нет.
     * @throws IOException
     */
    private int send(String url) throws IOException {
//        InputStream strm = HttpServer.class.getResourceAsStream(url);
//        InputStream strm = HttpServer.class.getResourceAsStream(String.valueOf(z1http.HttpServer.class.getResource("c:\\111\\1.a")));
//        int code = (strm != null) ? 200 : 404;
//        String header = getHeader(code);
        String header = getHeader(200);
        PrintStream answer = new PrintStream(out, true, "UTF-8");
        answer.print(header);
//        if (code == 200) {
        byte[] buffer = new byte[length];
        int count = z1http.HttpServer.max / length + 1;

        final String string = "%PDF-1.3\n" +
                "1 0 obj\n" +
                "<</Type /XObject /Subtype /Image /Name /Im1 /Width 1654 /Height 2338 /Length 291569/ColorSpace /DeviceRGB /BitsPerComponent 8 /Filter [ /DCTDecode ] >> stream\n" +
                "яШяа \u0010JFIF \u0001\u0001\u0001 И И  яЫ C \b\u0006\u0006\u0007\u0006\u0005\b\u0007\u0007\u0007\t\t\b\n" +
                "\f\u0014\n" +
                "\f\u000B\u000B\f\u0019\u0012\u0013\u000F\u0014\u001D\u001A\u001F\u001E\u001D\u001A\u001C\u001C $.' \",#\u001C\u001C(7),01444\u001F'9=82<.342яЫ C\u0001\t\t\t\f\u000B\f\u0018\n" +
                "\n" +
                "\u00182!\u001C!22222222222222222222222222222222222222222222222222яА \u0011\b\t\"\u0006v\u0003\u0001\" \u0002\u0011\u0001\u0003\u0011\u0001яД \u001F  \u0001\u0005\u0001\u0001\u0001\u0001\u0001\u0001        \u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n" +
                "\u000BяД µ\u0010 \u0002\u0001\u0003\u0003\u0002\u0004\u0003\u0005\u0005\u0004\u0004  \u0001}\u0001\u0002\u0003 \u0004\u0011\u0005\u0012!1A\u0006\u0013Qa\u0007\"q\u00142Ѓ‘Ў\b#B±Б\u0015RСр$3br‚\t\n" +
                "\u0016\u0017\u0018\u0019\u001A%&'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzѓ„…†‡€‰Љ’“”•–—\u0098™љўЈ¤Ґ¦§Ё©ЄІіґµ¶·ё№єВГДЕЖЗИЙКТУФХЦЧШЩЪбвгдежзийкстуфхцчшщъяД \u001F\u0001 \u0003\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001      \u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n" +
                "\u000BяД µ\u0011 \u0002\u0001\u0002\u0004\u0004\u0003\u0004\u0007\u0005\u0004\u0004 \u0001\u0002w \u0001\u0002\u0003\u0011\u0004\u0005!1\u0006\u0012AQ\u0007aq\u0013\"2Ѓ\b\u0014B‘Ў±Б\t#3Rр\u0015brС\n" +
                "\u0016$4б%с\u0017\u0018\u0019\u001A&'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ѓ„…†‡€‰Љ’“”•–—\u0098™љўЈ¤Ґ¦§Ё©ЄІіґµ¶·ё№єВГДЕЖЗИЙКТУФХЦЧШЩЪвгдежзийктуфхцчшщъяЪ \f\u0003\u0001 \u0002\u0011\u0003\u0011 ? чъ(ўЂ\n";
        out.write(string.getBytes());
        for (int i = 0; i < count; i++) {
            out.write(gen(length).getBytes());
        }
//            strm.close();
//        }
        return 200;
    }

    private static String gen(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = length; i > 0; i -= 12) {
            int n = min(12, abs(i));
            sb.append((Long.toString(round(random() * pow(36, n)), 36)));
        }
        return sb.toString();
    }

    /**
     * Возвращает http заголовок ответа.
     *
     * @param code код результата отправки.
     * @return http заголовок ответа.
     */
    private String getHeader(int code) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("HTTP/1.1 ").append(code).append(" ").append(getAnswer(code)).append(System.lineSeparator());
        buffer.append("Date: ").append(new Date().toGMTString()).append(System.lineSeparator());
        buffer.append("Accept-Ranges: none" + System.lineSeparator());
//        buffer.append("Content-Type: " + "text/html" + "\n");
        buffer.append("Content-Type: " + "application/zip").append(System.lineSeparator());
        buffer.append("Content-Disposition: " + "attachment; filename=zagl_doc.pdf" + System.lineSeparator());
//        Content-Type: application/zip
//        Content-Disposition: attachment; filename=gs-producing-web-service-master.zip
        buffer.append(System.lineSeparator());
        return buffer.toString();
    }

    /**
     * Возвращает комментарий к коду результата отправки.
     *
     * @param code код результата отправки.
     * @return комментарий к коду результата отправки.
     */
    private String getAnswer(int code) {
        switch (code) {
            case 200:
                return "OK";
            case 404:
                return "Not Found";
            default:
                return "Internal Server Error";
        }
    }

}
