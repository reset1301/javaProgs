package ru.rrr.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.dao.FlightDB;
import ru.rrr.dao.PlaceDB;
import ru.rrr.entities.*;
import ru.rrr.service_interfaces.Search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component("searchFlights")
public class SearchImpl implements Search, ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public List<Flight> searchFlight(long date, City cityFrom, City cityTo, int placeCount) {
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
