package ru.rrr.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.dao.dao_interfaces.AbstractSearchDb;
import ru.rrr.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component("flightDB")
public class FlightDB implements ApplicationContextAware {
    private ApplicationContext ctx;

    public Flight getFlightById(long id) throws SQLException {
        String selectFlightById = (String) ctx.getBean("selectFlightById");
        AbstractSearchDb abstractSearchDb = (AbstractSearchDb) ctx.getBean("selectToDB");
//        Statement statement = ctx.getBean("statement", Statement.class);
//        ResultSet resultSet = statement.executeQuery(String.format(selectFlightById, id));
        ResultSet resultSet = abstractSearchDb.getObjectById(selectFlightById, id);
        Flight flight = new Flight();
        while (resultSet.next()) {
            flight.setId(id);
            flight.setCode(resultSet.getString("code"));
            flight.setFlightDate(resultSet.getLong("flight_date"));
            flight.setFlightCome(resultSet.getLong("flight_come"));
            CityDB city = (CityDB) ctx.getBean("cityDB");
            flight.setCityFrom(city.getCityById(resultSet.getLong("city_from_id")));
            flight.setCityTo(city.getCityById(resultSet.getLong("city_to_id")));
            AircraftDB aircraftDB = ctx.getBean("aircraftDB", AircraftDB.class);
            flight.setAircraft(aircraftDB.getAircraftById(resultSet.getLong("aircraft_id")));
        }
        return flight;
    }

    public List<Flight> getFlightsByDatePlaceCountCityFromCityTo(long date, City cityFrom, City cityTo, int placeCount) {
        Statement statement = ctx.getBean("statement", Statement.class);
        ResultSet resultSet = null;
        try {
            resultSet = getResultSet(date, cityFrom, cityTo, statement);

            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                Flight flight = getFlight(resultSet, placeCount);
                if (flight != null) {
                    flights.add(flight);
                }
            }
            log.info("Find: " + flights.size() + " flights.");
            resultSet.close();

            return flights;
        } catch (Exception e) {
            log.error("Error occurs when execute query: " + e);
            return null;
        }
    }

    private ResultSet getResultSet(long date, City cityFrom, City cityTo, Statement statement) throws SQLException {
        ResultSet resultSet;
        String formatSelectSearchFlight = ctx.getBean("formatSelectSearchFlight", String.class);
        resultSet = statement.executeQuery(
                String.format(formatSelectSearchFlight,
                        date, cityFrom.getName(), cityTo.getName()
                ));
        return resultSet;
    }

    private Flight getFlight(ResultSet resultSet, int placeCount) throws SQLException, ParseException {
        long aircraftId = resultSet.getLong("aircraftId");
        String aircraftName = resultSet.getString("aircraftName");
        String code = resultSet.getString("code");
        long flightId = resultSet.getLong("flightId");
        Company company = new Company(resultSet.getLong("companyId"), resultSet.getString("name"),
                resultSet.getString("aircraftDescr"));
        Country countryFrom = new Country(resultSet.getLong("countryFromId"),
                resultSet.getString("countryFromName"),
                resultSet.getString("countryFromFlag"),
                resultSet.getString("countryFromShortname"));
        Country countryTo = new Country(resultSet.getLong("countryToId"),
                resultSet.getString("countryToName"),
                resultSet.getString("countryToFlag"),
                resultSet.getString("countryToShortname"));
        City cityFr = new City(resultSet.getLong("cityFromId"),
                resultSet.getString("cityFromName"),
                resultSet.getString("cityFromPostcode"), countryFrom);
        City cityT = new City(resultSet.getLong("cityToId"), resultSet.getString("cityToName"),
                resultSet.getString("cityToPostcode"), countryTo);

        long fDate = resultSet.getLong("flightDate");
        long fCome = resultSet.getLong("flightCome");

        PlaceDB placeDB = (PlaceDB) ctx.getBean("placeDB");
        if (placeDB.countPlacesByAircraftId(aircraftId) < placeCount) {
            log.info("In aircraft '" + code + "' not enough free places.");
            return null;
        }
        List<Place> places = placeDB.getPlacesByAircraftId(aircraftId);

        if (places == null) return null;
        Aircraft aircraft = new Aircraft(aircraftId, aircraftName, places, company);

        return new Flight(flightId, code, fDate, fCome, aircraft, cityFr, cityT);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
