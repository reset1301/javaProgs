package ru.rrr.entities;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = false, length = 255)
    private String flag;
    @Column(length = 255)
    private String shortname;

    public Country() {
    }

    public Country(long id, String name, String flag, String shortname) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.shortname = shortname;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                ", shortname='" + shortname + '\'' +
                '}';
    }
}
