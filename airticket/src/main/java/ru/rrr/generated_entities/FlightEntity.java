package ru.rrr.generated_entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "public", catalog = "airticket")
public class FlightEntity {
    private long id;
    private String code;
    private Timestamp flightDate;
    private Timestamp flightTime;
    private long aircraftId;
    private long duration;
    private long cityFromId;
    private long cityToId;
    private SprAircraftEntity sprAircraftByAircraftId;
    private SprCityEntity sprCityByCityFromId;
    private SprCityEntity sprCityByCityToId;
    private Collection<ReservationEntity> reservationsById;

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
    @Column(name = "aircraft_id", nullable = false)
    public long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(long aircraftId) {
        this.aircraftId = aircraftId;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "city_from_id", nullable = false)
    public long getCityFromId() {
        return cityFromId;
    }

    public void setCityFromId(long cityFromId) {
        this.cityFromId = cityFromId;
    }

    @Basic
    @Column(name = "city_to_id", nullable = false)
    public long getCityToId() {
        return cityToId;
    }

    public void setCityToId(long cityToId) {
        this.cityToId = cityToId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return id == that.id &&
                aircraftId == that.aircraftId &&
                duration == that.duration &&
                cityFromId == that.cityFromId &&
                cityToId == that.cityToId &&
                Objects.equals(code, that.code) &&
                Objects.equals(flightDate, that.flightDate) &&
                Objects.equals(flightTime, that.flightTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, flightDate, flightTime, aircraftId, duration, cityFromId, cityToId);
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
    @JoinColumn(name = "city_from_id", referencedColumnName = "id", nullable = false)
    public SprCityEntity getSprCityByCityFromId() {
        return sprCityByCityFromId;
    }

    public void setSprCityByCityFromId(SprCityEntity sprCityByCityFromId) {
        this.sprCityByCityFromId = sprCityByCityFromId;
    }

    @ManyToOne
    @JoinColumn(name = "city_to_id", referencedColumnName = "id", nullable = false)
    public SprCityEntity getSprCityByCityToId() {
        return sprCityByCityToId;
    }

    public void setSprCityByCityToId(SprCityEntity sprCityByCityToId) {
        this.sprCityByCityToId = sprCityByCityToId;
    }

    @OneToMany(mappedBy = "flightByFlightId")
    public Collection<ReservationEntity> getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(Collection<ReservationEntity> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
