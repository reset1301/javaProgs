package ru.rrr.generated_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "public", catalog = "airticket")
public class ReservationEntity {
    private long id;
    private long flightId;
    private long passengerId;
    private int placeId;
    private String addInfo;
    private int reserveDatetime;
    private String code;
    private FlightEntity flightByFlightId;
    private PassengerEntity passengerByPassengerId;
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
    @Column(name = "flight_id", nullable = false)
    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "passenger_id", nullable = false)
    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    @Basic
    @Column(name = "place_id", nullable = false)
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "add_info", nullable = true, length = 255)
    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    @Basic
    @Column(name = "reserve_datetime", nullable = false)
    public int getReserveDatetime() {
        return reserveDatetime;
    }

    public void setReserveDatetime(int reserveDatetime) {
        this.reserveDatetime = reserveDatetime;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return id == that.id &&
                flightId == that.flightId &&
                passengerId == that.passengerId &&
                placeId == that.placeId &&
                reserveDatetime == that.reserveDatetime &&
                Objects.equals(addInfo, that.addInfo) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, passengerId, placeId, addInfo, reserveDatetime, code);
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    public FlightEntity getFlightByFlightId() {
        return flightByFlightId;
    }

    public void setFlightByFlightId(FlightEntity flightByFlightId) {
        this.flightByFlightId = flightByFlightId;
    }

    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id", nullable = false)
    public PassengerEntity getPassengerByPassengerId() {
        return passengerByPassengerId;
    }

    public void setPassengerByPassengerId(PassengerEntity passengerByPassengerId) {
        this.passengerByPassengerId = passengerByPassengerId;
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
