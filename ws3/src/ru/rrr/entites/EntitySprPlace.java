package ru.rrr.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "spr_place", schema = "public", catalog = "airticket")
public class EntitySprPlace {
    private long id;
    private String row;
    private long seat;
    private EntitySprFlightClass sprFlightClassByFlightClassId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "row", nullable = false, length = 255)
    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    @Basic
    @Column(name = "seat", nullable = false)
    public long getSeat() {
        return seat;
    }

    public void setSeat(long seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitySprPlace that = (EntitySprPlace) o;
        return id == that.id &&
                seat == that.seat &&
                Objects.equals(row, that.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, seat);
    }

    @ManyToOne
    @JoinColumn(name = "flight_class_id", referencedColumnName = "id", nullable = false)
    public EntitySprFlightClass getSprFlightClassByFlightClassId() {
        return sprFlightClassByFlightClassId;
    }

    public void setSprFlightClassByFlightClassId(EntitySprFlightClass sprFlightClassByFlightClassId) {
        this.sprFlightClassByFlightClassId = sprFlightClassByFlightClassId;
    }
}
