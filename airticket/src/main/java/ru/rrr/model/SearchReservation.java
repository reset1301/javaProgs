package ru.rrr.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.dao.ReservationDB;
import ru.rrr.entities.Flight;
import ru.rrr.entities.Reservation;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Component("searchReservation")
public class SearchReservation implements ApplicationContextAware {
    private ApplicationContext ctx;

    public List<Reservation> search(Flight flight) {
        ReservationDB reservationDB = ctx.getBean("reservationDB", ReservationDB.class);
        try {
            return reservationDB.searchByFlight(flight);
        } catch (SQLException e) {
            log.error("Search reservation error", e);
            return null;
        }
    }

    public List<Reservation> search(long flightID) {
        ReservationDB reservationDB = ctx.getBean("reservationDB", ReservationDB.class);
        try {
            return reservationDB.searchByFlightId(flightID);
        } catch (SQLException e) {
            log.error("Search reservation error", e);
            return null;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
