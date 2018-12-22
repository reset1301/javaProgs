package hello.dao;

import hello.dao.interfaces.DocsCountries;

import javax.persistence.*;

@Entity
@Table(name = "countries", schema = "public", catalog = "org")
public class Countries implements DocsCountries {
    private long id;
    private String name;
    private String code;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
