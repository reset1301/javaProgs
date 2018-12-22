package ru.rrr.generated_entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "spr_place", schema = "public", catalog = "airticket")
public class SprPlaceEntity {
    private long id;
    private String row;
    private long seat;
    private long flightClassId;
    private Collection<ReservationEntity> reservationsById;
    private Collection<SprAircraftPlaceEntity> sprAircraftPlacesById;
    private SprFlightClassEntity sprFlightClassByFlightClassId;

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

    @Basic
    @Column(name = "flight_class_id", nullable = false)
    public long getFlightClassId() {
        return flightClassId;
    }

    public void setFlightClassId(long flightClassId) {
        this.flightClassId = flightClassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprPlaceEntity that = (SprPlaceEntity) o;
        return id == that.id &&
                seat == that.seat &&
                flightClassId == that.flightClassId &&
                Objects.equals(row, that.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, seat, flightClassId);
    }

    @OneToMany(mappedBy = "sprPlaceByPlaceId")
    public Collection<ReservationEntity> getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(Collection<ReservationEntity> reservationsById) {
        this.reservationsById = reservationsById;
    }

    @OneToMany(mappedBy = "sprPlaceByPlaceId")
    public Collection<SprAircraftPlaceEntity> getSprAircraftPlacesById() {
        return sprAircraftPlacesById;
    }

    public void setSprAircraftPlacesById(Collection<SprAircraftPlaceEntity> sprAircraftPlacesById) {
        this.sprAircraftPlacesById = sprAircraftPlacesById;
    }

    @ManyToOne
    @JoinColumn(name = "flight_class_id", referencedColumnName = "id", nullable = false)
    public SprFlightClassEntity getSprFlightClassByFlightClassId() {
        return sprFlightClassByFlightClassId;
    }

    public void setSprFlightClassByFlightClassId(SprFlightClassEntity sprFlightClassByFlightClassId) {
        this.sprFlightClassByFlightClassId = sprFlightClassByFlightClassId;
    }
}
