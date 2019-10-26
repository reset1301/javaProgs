package hello.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity(name = "spr_flight_class")
public class FlightClassEntity {
    private long id;
    private String name;
    private String descr;

    @Id
    @JsonIgnore
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
    @JsonProperty("description")
    @Column(name = "descr", nullable = true, length = 255)
    public String getDescr()  {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightClassEntity that = (FlightClassEntity) o;
        return id == that.id &&
          Objects.equals(name, that.name) &&
          Objects.equals(descr, that.descr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descr);
    }
}
