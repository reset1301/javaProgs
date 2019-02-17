package ru.rrr.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.dao.FlightDB;
import ru.rrr.entities.City;
import ru.rrr.entities.Flight;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Slf4j
@Component("searchFlights")
public class SearchImpl implements ApplicationContextAware {
    private ApplicationContext ctx;

    public List<Flight> searchFlight(long date, City cityFrom, City cityTo, int placeCount) throws SQLException, ClassNotFoundException {
        FlightDB flightDB = (FlightDB) ctx.getBean("flightDB");
        return flightDB.getFlightsByDatePlaceCountCityFromCityTo(date, cityFrom, cityTo, placeCount);
    }

    public String printFlights(List<Flight> flights) {
        StringBuffer sb = new StringBuffer();
        for (Flight f : flights) {
            sb.append("Flight: " + f.getCode()
                    + "\tDeparture: " + new Date(f.getFlightDate()).toString()
                    + "\tDuration: " + ((f.getFlightCome() - f.getFlightDate()) / 3600000) + " hours, "
                    + ((f.getFlightCome() - f.getFlightDate()) % 3600000 / 60000) + " mins "
                    + "\tCity from: " + f.getCityFrom().getName()
                    + "\tCountry from: " + f.getCityFrom().getCountry().getShortname()
                    + "\tCity to: " + f.getCityTo().getName()
                    + "\tCountry to: " + f.getCityTo().getCountry().getShortname()
                    + "\tAircraft: " + f.getAircraft().getName()
                    + "\tCompany: " + f.getAircraft().getCompany().getName() + "\n"
            );
        }
        return sb.toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
