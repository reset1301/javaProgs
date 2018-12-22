package ru.rrr.generated_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "spr_aircraft_place", schema = "public", catalog = "airticket")
public class SprAircraftPlaceEntity {
    private long id;
    private long aircraftId;
    private long placeId;
    private SprAircraftEntity sprAircraftByAircraftId;
    private SprPlaceEntity sprPlaceByPlaceId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "aircraft_id", nullable = false)
    public long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(long aircraftId) {
        this.aircraftId = aircraftId;
    }

    @Basic
    @Column(name = "place_id", nullable = false)
    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprAircraftPlaceEntity that = (SprAircraftPlaceEntity) o;
        return id == that.id &&
                aircraftId == that.aircraftId &&
                placeId == that.placeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aircraftId, placeId);
    }

    @ManyToOne
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id", nullable = false)
    public SprAircraftEntity getSprAircraftByAircraftId() {
        return sprAircraftByAircraftId;
    }

    public void setSprAircraftByAircraftId(SprAircraftEntity sprAircraftByAircraftId) {
        this.sprAircraftByAircraftId = sprAircraftByAircraftId;
    }

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    public SprPlaceEntity getSprPlaceByPlaceId() {
        return sprPlaceByPlaceId;
    }

    public void setSprPlaceByPlaceId(SprPlaceEntity sprPlaceByPlaceId) {
        this.sprPlaceByPlaceId = sprPlaceByPlaceId;
    }
}
