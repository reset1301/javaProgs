package ru.rrr.generated_entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "spr_flight_class", schema = "public", catalog = "airticket")
public class SprFlightClassEntity {
    private long id;
    private String name;
    private String descr;
    private Collection<SprPlaceEntity> sprPlacesById;

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
    @Column(name = "descr", nullable = true, length = 255)
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprFlightClassEntity that = (SprFlightClassEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(descr, that.descr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descr);
    }

    @OneToMany(mappedBy = "sprFlightClassByFlightClassId")
    public Collection<SprPlaceEntity> getSprPlacesById() {
        return sprPlacesById;
    }

    public void setSprPlacesById(Collection<SprPlaceEntity> sprPlacesById) {
        this.sprPlacesById = sprPlacesById;
    }
}
