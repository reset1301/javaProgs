package ru.rrr.generated_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "spr_country", schema = "public", catalog = "airticket")
public class SprCountryEntity {
    private long id;
    private String name;
    private String shortname;
    private String flag;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "shortname", nullable = false, length = 255)
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Basic
    @Column(name = "flag", nullable = true, length = 255)
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprCountryEntity that = (SprCountryEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortname, that.shortname) &&
                Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortname, flag);
    }
}
