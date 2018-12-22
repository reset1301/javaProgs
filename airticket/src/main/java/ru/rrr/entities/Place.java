package ru.rrr.entities;

import javax.persistence.*;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, length = 255)
    private String row;
    @Column(nullable = false)
    private long seat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_class_id",referencedColumnName = "id")
    private FlightClass flightClass;

    public Place() {
    }

    public Place(long id, String row, long seat, FlightClass flightClass) {
        this.id = id;
        this.row = row;
        this.seat = seat;
        this.flightClass = flightClass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public long getSeat() {
        return seat;
    }

    public void setSeat(long seat) {
        this.seat = seat;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    @Override
    public String toString() {
        return "Place{" +
                "row='" + row + '\'' +
                ", seat=" + seat +
                ", flightClass=" + flightClass +
                '}';
    }
}
