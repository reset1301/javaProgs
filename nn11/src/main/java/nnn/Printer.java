package nnn;

import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("printer")
public class Printer {
//    @Value("Hello world!")
//    @Autowired
    @Resource(name = "printMessage2")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
