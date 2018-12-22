package hello.dao;

import hello.dao.interfaces.DocsCountries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "docs", schema = "public", catalog = "org")
public class Docs implements DocsCountries {
    private long id;
    private String name;
    private String code;

    @Id
    @Column(name = "id", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column()
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}