package ru.rrr.entities;

import java.util.Calendar;

public class Reservation {
    private long id;
    private Flight flight;
    private Passenger passenger;
    private Place place;
    private String addInfo;
    private Calendar reserveDateTime;
    private String code;

    public Reservation(long id, Flight flight, Passenger passenger, Place place, String addInfo, Calendar reserveDateTime, String code) {
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

    public Calendar getReserveDateTime() {
        return reserveDateTime;
    }

    public void setReserveDateTime(Calendar reserveDateTime) {
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
