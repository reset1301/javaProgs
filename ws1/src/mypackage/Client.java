package mypackage;

import example.HelloWorld;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@RequestScoped
public class Client {
    private String correctedName;
    private String name;

    public String getCorrectedName() {
        return correctedName;
    }

    public void setCorrectedName(String correctedName) {
        this.correctedName = correctedName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void correctName() {
        HelloWorld helloWorld = new HelloWorld();
        HelloWorld port=
    }
}
