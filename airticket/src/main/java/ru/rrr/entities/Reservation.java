package ru.rrr.entities;

import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false)
    private Flight flight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id", nullable = false)
    private Passenger passenger;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;
    @Column(length = 255)
    private String addInfo;
    @Column(nullable = false)
    private long reserveDateTime;
    @Column(nullable = false, unique = true, length = 255)
    private String code;

    public Reservation() {
    }

    public Reservation(long id, Flight flight, Passenger passenger, Place place, String addInfo, long reserveDateTime, String code) {
        this.id = id;
        this.flight = flight;
        this.passenger = passenger;
        this.place = place;
        this.addInfo = addInfo;
        this.reserveDateTime = reserveDateTime;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public long getReserveDateTime() {
        return reserveDateTime;
    }

    public void setReserveDateTime(long reserveDateTime) {
        this.reserveDateTime = reserveDateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "flight=" + flight +
                ", passenger=" + passenger +
                ", place=" + place +
                ", addInfo='" + addInfo + '\'' +
                ", reserveDateTime=" + reserveDateTime +
                ", code='" + code + '\'' +
                '}';
    }
}
