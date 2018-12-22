package ru.rrr.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "spr_aircraft_place", schema = "public", catalog = "airticket")
public class EntitySprAircraftPlace {
    private long id;
    private EntitySprAircraft sprAircraftByAircraftId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitySprAircraftPlace that = (EntitySprAircraftPlace) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id", nullable = false)
    public EntitySprAircraft getSprAircraftByAircraftId() {
        return sprAircraftByAircraftId;
    }

    public void setSprAircraftByAircraftId(EntitySprAircraft sprAircraftByAircraftId) {
        this.sprAircraftByAircraftId = sprAircraftByAircraftId;
    }
}
