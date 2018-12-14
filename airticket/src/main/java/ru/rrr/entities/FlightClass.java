package ru.rrr.entities;

import javax.persistence.*;

@Entity
public class FlightClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(length = 255)
    private String descr;

    public FlightClass(long id, String name, String descr) {
        this.id = id;
        this.name = name;
        this.descr = descr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "FlightClass{" +
                "name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }
}
