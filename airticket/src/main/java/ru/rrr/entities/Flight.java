package ru.rrr.entities;

import javax.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(unique = true, nullable = false, length = 255)
    private String code;
    @Column(nullable = false)
    private long flightDate;
    @Column(nullable = false)
    private long flightCome;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id")
    private Aircraft aircraft;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_from_id", referencedColumnName = "id")
    private City cityFrom;
    @ManyToOne
    @JoinColumn(name = "city_to_id", referencedColumnName = "id")
    private City cityTo;

    public Flight() {

    }

    public Flight(long id, String code, long flightDate, long flightCome, Aircraft aircraft, City cityFrom, City cityTo) {
        this.id = id;
        this.code = code;
        this.flightDate = flightDate;
        this.flightCome = flightCome;
        this.aircraft = aircraft;
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

    public long getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(long flightDate) {
        this.flightDate = flightDate;
    }

    public long getFlightCome() {
        return flightCome;
    }

    public void setFlightCome(long flightCome) {
        this.flightCome = flightCome;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
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
                ", flightCome=" + flightCome +
                ", aircraft=" + aircraft +
                ", cityFrom=" + cityFrom +
                ", cityTo=" + cityTo +
                '}';
    }
}
