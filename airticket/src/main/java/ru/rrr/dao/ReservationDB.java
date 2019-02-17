package ru.rrr.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rrr.entities.Flight;
import ru.rrr.entities.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component("reservationDB")
public class ReservationDB {
    @Autowired
    private String selectReservationByFlight;
    @Autowired
    private FlightDB flightDB;
    @Autowired
    private PlaceDB placeDB;
    @Autowired
    private PassengerDB passengerDB;
    @Autowired
    private Statement statement;

    public List<Reservation> searchByFlight(Flight flight) throws SQLException {
        return searchByFlightId(flight.getId());
    }

    public List<Reservation> searchByFlightId(long id) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(String.format(selectReservationByFlight, id));
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setFlight(flightDB.getFlightById(id));
                reservation.setCode(resultSet.getString("code"));
                reservation.setAddInfo(resultSet.getString("add_info"));
                reservation.setId(resultSet.getLong("id"));
                reservation.setReserveDateTime(resultSet.getLong("reserve_datetime"));
                reservation.setPlace(placeDB.getPlaceById(resultSet.getLong("place_id")));
                reservation.setPassenger(passengerDB.getPassengerById(resultSet.getLong("passenger_id")));
                reservations.add(reservation);
            }
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            log.error("Search reservation by flight error: ", e);
            return null;
        }
        if (statement != null)
            statement.close();
        return reservations;
    }
}
