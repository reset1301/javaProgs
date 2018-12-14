package ru.rrr.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true, nullable = false, length = 255)
    private String code;
    @Column(nullable = false)
    private LocalDate flightDate;
    @Column(nullable = false)
    private LocalTime flightTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    private Aircraft aircraft;
    @Column
    private long duration;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_from_id", referencedColumnName = "id")
    private City cityFrom;
    @ManyToOne
    @JoinColumn(name = "city_to_id", referencedColumnName = "id")
    private City cityTo;

    public Flight() {

    }

    public Flight(long id, String code, LocalDate flightDate, LocalTime flightTime, Aircraft aircraft, long duration, City cityFrom, City cityTo) {
        this.id = id;
        this.code = code;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.aircraft = aircraft;
        this.duration = duration;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "code='" + code + '\'' +
                ", flightDate=" + flightDate +
                ", flightTime=" + flightTime +
                ", aircraft=" + aircraft +
                ", duration=" + duration +
                ", cityFrom=" + cityFrom +
                ", cityTo=" + cityTo +
                '}';
    }
}
