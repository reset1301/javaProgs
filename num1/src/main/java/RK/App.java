package RK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
//            String s = "select 1,2,3 from logs where response > 1000 and date between 23/09/2018:15:23:45 and 13/01/2019:12:34:56";
//            String[] ss = s.split(" ");
            System.out.println("Скрипт парсинга лог-файлов формата:" + System.lineSeparator() +
                    "Время " +
                    "Значение " +
                    "Адрес " +
                    "Дата/время(ДД/ММ/ГГГГ:ЧЧ:мм:сс +0400) " +
                    "ip " +
                    "- " +
                    "Тип_запроса(POST/GET) " +
                    "Заголовок_ответа " +
                    "- " +
                    "upstream_responce: " +
                    "Время_ответа" +
                    System.lineSeparator() +
                    System.lineSeparator() +
                    "Программа распарсивает все log-файлы в указанной папке. " +
                    System.lineSeparator() +
                    "Путь можно ввести как первым параметром при запуске программы, так и после запуска." +
                    System.lineSeparator() +
                    "Также для удобства можно вывести как все поля и времена, так и выбранные по дате и/или времени ответа в миллисекундах" +
                    System.lineSeparator() +
                    "Для этого вторым параметром можно указать * для вывода всего лог-файла либо в формате: " +
                    System.lineSeparator() +
                    "select *(либо номера полей от 1 до 9 через запятую без пробелов) from logs " +
                    "where response >(<) время_в_мсек " +
                    "and date between ДД/ММ/ГГГГ:ЧЧ:мм:сс and ДД/ММ/ГГГГ:ЧЧ:мм:сс" +
                    System.lineSeparator()
            );

            LogParser logParser = null;
            if (args.length > 0) {
                logParser = new LogParser(Paths.get(args[0]));
                if (args.length > 1)
                    logParser.query = args[1];
                else logParser.query = "*";
            }
            if (logParser == null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Helper.printMessage("Введите папку с лог-файлами: ");
                logParser = new LogParser(Paths.get(br.readLine()));
                Helper.printMessage("Введите выражение: ");
                logParser.query = br.readLine();
                br.close();
            }
//            logParser.parseQuery();
//            logParser = new LogParser(Paths.get("c:\\111\\PerfomanceLab\\td_logParser"));

//            String s = "Aug  4 00:00:06 p00esianlbext01 esia.gosuslugi.ru_https_access: 03/Aug/2014:23:59:57 +0400 109.165.86.241 - GET /idp/AuthnEngine HTTP/1.1 \"302\" 0.011 1407095997.009 311 \"http://www.gosuslugi.ru/pgu/personcab\" \"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36\" - upstream_responce: 0.011";
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
//        String date = s.split(" ")[0];
//        System.out.println(date);
//        System.out.println(sdf.parse(date));
//        logParser.readFiles();
//        System.out.println(s.indexOf("p00"));
//        System.out.println(s.substring(0,s.indexOf("p00")).trim());
//        String p00 = s.substring(s.indexOf("p00"));
//        System.out.println(p00.substring(0,p00.indexOf(" ")).trim());
//        logParser.proccessWithLine(s);
//        logParser.after =
//                new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH).
//                        parse("03/Aug/2014:23:59:56");
//        logParser.before=
//                new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH).
//                        parse("03/Aug/2014:23:59:58");
//        System.out.println(logParser.isInDate(logParser.partOfLog.field4ToDate("03/Aug/2014:23:59:57 +0400")));
//        System.out.println(logParser.isResponseMoreThanThreshold(100));
            logParser.readFiles();
        } catch (Exception e) {
            LogException.log(e);
        }
    }
}
