package ru.rrr.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import ru.rrr.business_interfaces.Search;
import ru.rrr.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class SearchImpl implements Search {
    private ApplicationContext ctx;

    public SearchImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<Flight> searchFlight(Date date, City cityFrom, City cityTo, int placeCount) {
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

            return flights;
        } catch (Exception e) {
            log.error("Error occurs when execute query: " + e);
            return null;
        }
    }

    private ResultSet getResultSet(Date date, City cityFrom, City cityTo, Statement statement) throws SQLException {
        ResultSet resultSet;
        String formatSelectSearchFlight = ctx.getBean("formatSelectSearchFlight", String.class);
        resultSet = statement.executeQuery(
                String.format(
                        formatSelectSearchFlight,
                        new SimpleDateFormat("dd-MM-yyyy").format(date),
                        new SimpleDateFormat("dd-MM-yyyy").format(date),
                        new SimpleDateFormat("hh:mm:ss").format(date),
                        cityFrom.getName(), cityTo.getName()
                ));
        return resultSet;
    }

    private Flight getFlight(ResultSet resultSet, int placeCount) throws SQLException, ParseException {
        long aircraftId = resultSet.getLong("aircraftId");
        String code = resultSet.getString("code");

        Statement stmt = ctx.getBean("statement", Statement.class);
        String formatSelectSearchFlight = ctx.getBean("formatSelectFlightPlaces", String.class);
        ResultSet result = null;
        int freePlaces = Integer.MIN_VALUE;
        try {
            result = stmt.executeQuery(String.format(formatSelectSearchFlight, aircraftId));
            while (result.next()) {
                freePlaces = result.getInt(1);
            }
        } catch (Exception e) {
            log.error("Error invoking count of places!");
            return null;
        }
        if (freePlaces < placeCount) {
            log.info("In aircraft " + code + " not enough free places.");
            return null;
        }
        String selectFlightPlaces = ctx.getBean("selectFlightPlaces", String.class);
        result = null;
        try {
            result = stmt.executeQuery(String.format(selectFlightPlaces, aircraftId));
        } catch (Exception e) {
            log.error("Error invoking count of places");
        }
        List<Place> places = new ArrayList<>();
        if (result != null) {
            while (result.next()) {
                long placeId = result.getLong("placeid");
                String row = result.getString("row");
                long seat = result.getLong("seat");
                long classId = result.getLong("classId");
                String className = result.getString("className");
                String classDescr = result.getString("classDescr");
                FlightClass flightClass = new FlightClass(classId, className, classDescr);
                places.add(new Place(placeId, row, seat, flightClass));
            }
        }
        Company company = new Company(resultSet.getLong("companyId"), resultSet.getString("name"),
                resultSet.getString("aircraftDescr"));
        Aircraft aircraft = new Aircraft(resultSet.getLong("aircraftId"), resultSet.getString("aircraftName"), places, company);

        Country countryFrom = new Country(resultSet.getLong("countryFromId"), resultSet.getString("countryFromName"),
                resultSet.getString("countryFromFlag"),
                resultSet.getString("countryFromShortname"));
        Country countryTo = new Country(resultSet.getLong("countryToId"), resultSet.getString("countryToName"),
                resultSet.getString("countryToFlag"),
                resultSet.getString("countryToShortname"));

        City cityFr = new City(resultSet.getLong("cityFromId"), resultSet.getString("cityFromName"),
                resultSet.getString("cityFromPostcode"), countryFrom);
        City cityT = new City(resultSet.getLong("cityToId"), resultSet.getString("cityToName"),
                resultSet.getString("cityToPostcode"), countryTo);

        LocalDate fDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                .parse(resultSet.getString("flightDate"))
                .toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime fTime = new SimpleDateFormat("hh:mm:ss")
                .parse(resultSet.getString("flightTime").split("\\s")[1])
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalTime();

        return new Flight(resultSet.getLong("flightId"), code, fDate, fTime,
                aircraft, resultSet.getLong("duration"), cityFr, cityT);
    }
}
