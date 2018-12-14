package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr_pass_phr")
public class PassPhr {
    @Id
    private Long id;
    private String passPhrase;

    public PassPhr(Long id, String passPhrase) {
        this.id = id;
        this.passPhrase = passPhrase;
    }

    public String getPassPhrase() {
        return passPhrase;
    }

    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }
}
