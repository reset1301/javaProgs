package nnn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("contextAnnotaion.xml");
        Printer printer = (Printer) ctx.getBean("printer");
        printer.print();
    }
}
