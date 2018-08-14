package com.roma.entity;

public class User {
    private String name;
    private String fam;
    private String patr;

    public User(String name, String fam, String patr) {
        this.name = name;
        this.fam = fam;
        this.patr = patr;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getPatr() {
        return patr;
    }

    public void setPatr(String patr) {
        this.patr = patr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", fam='" + fam + '\'' +
                ", patr='" + patr + '\'' +
                '}';
    }
}
