package ru.rrr.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
public class ReservationDB implements ApplicationContextAware {
    private ApplicationContext ctx;

    public List<Reservation> searchByFlight(Flight flight) throws SQLException {
        return searchByFlightId(flight.getId());
    }

    public List<Reservation> searchByFlightId(long id) throws SQLException {
        Statement statement = getStatement();
        List<Reservation> reservations = new ArrayList<>();
        try {
            String selectReservationByFlight = ctx.getBean("selectReservationByFlight", String.class);
            ResultSet resultSet = statement.executeQuery(String.format(selectReservationByFlight, id));
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                FlightDB flightDB = (FlightDB) ctx.getBean("flightDB");
                reservation.setFlight(flightDB.getFlightById(id));
                reservation.setCode(resultSet.getString("code"));
                reservation.setAddInfo(resultSet.getString("add_info"));
                reservation.setId(resultSet.getLong("id"));
                reservation.setReserveDateTime(resultSet.getLong("reserve_datetime"));
                PlaceDB placeDB = (PlaceDB) ctx.getBean("placeDB");
                reservation.setPlace(placeDB.getPlaceById(resultSet.getLong("place_id")));
                PassengerDB passengerDB = (PassengerDB) ctx.getBean("passengerDB");
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

    private Statement getStatement() {
        return ctx.getBean("statement", Statement.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
