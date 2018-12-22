package ru.rrr.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "public", catalog = "airticket")
public class EntityReservation {
    private long id;
    private String addInfo;
    private int reserveDatetime;
    private String code;
    private EntityFlight flightByFlightId;
    private EntityPassenger passengerByPassengerId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        EntityReservation that = (EntityReservation) o;
        return id == that.id &&
                reserveDatetime == that.reserveDatetime &&
                Objects.equals(addInfo, that.addInfo) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addInfo, reserveDatetime, code);
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    public EntityFlight getFlightByFlightId() {
        return flightByFlightId;
    }

    public void setFlightByFlightId(EntityFlight flightByFlightId) {
        this.flightByFlightId = flightByFlightId;
    }

    @ManyToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "id", nullable = false)
    public EntityPassenger getPassengerByPassengerId() {
        return passengerByPassengerId;
    }

    public void setPassengerByPassengerId(EntityPassenger passengerByPassengerId) {
        this.passengerByPassengerId = passengerByPassengerId;
    }
}
