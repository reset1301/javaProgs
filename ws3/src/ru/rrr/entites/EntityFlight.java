package ru.rrr.entites;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "public", catalog = "airticket")
public class EntityFlight {
    private long id;
    private String code;
    private Timestamp flightDate;
    private Timestamp flightTime;
    private long duration;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "flight_date", nullable = false)
    public Timestamp getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Timestamp flightDate) {
        this.flightDate = flightDate;
    }

    @Basic
    @Column(name = "flight_time", nullable = false)
    public Timestamp getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Timestamp flightTime) {
        this.flightTime = flightTime;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityFlight that = (EntityFlight) o;
        return id == that.id &&
                duration == that.duration &&
                Objects.equals(code, that.code) &&
                Objects.equals(flightDate, that.flightDate) &&
                Objects.equals(flightTime, that.flightTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, flightDate, flightTime, duration);
    }
}
