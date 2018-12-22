package ru.rrr.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.entities.FlightClass;
import ru.rrr.entities.Place;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component("placeDB")
public class PlaceDB implements ApplicationContextAware {
    private ApplicationContext ctx;

    public Place getPlaceById(long id) throws SQLException {
        String selectReservedPlaces = (String) ctx.getBean("selectReservedPlaces");
        Statement statement = ctx.getBean("statement", Statement.class);

        ResultSet resultSet = statement.executeQuery(String.format(selectReservedPlaces, id));
        Place place = new Place();
        while (resultSet.next()) {
            place.setId(resultSet.getLong("id"));
            place.setRow(resultSet.getString("row"));
            place.setSeat(resultSet.getLong("seat"));
            FlightClassDB flightClassDB = (FlightClassDB) ctx.getBean("flightClassDB");
            place.setFlightClass(flightClassDB.getFlightClassById(resultSet.getLong("flight_class_id")));
        }
        return place;
    }

    public List<Place> getPlacesByAircraftId(long aircraftId) throws SQLException {
        Statement stmt = ctx.getBean("statement", Statement.class);
        String selectFlightPlaces = ctx.getBean("selectFlightPlaces", String.class);
        ResultSet result1 = null;
        try {
            result1 = stmt.executeQuery(String.format(selectFlightPlaces, aircraftId));
        } catch (Exception e) {
            return null;
        }
        List<Place> places = new ArrayList<>();
        if (result1 != null) {
            while (result1.next()) {
                Place place = getPlace(result1);
                places.add(place);
            }
        }
        return places;
    }

    private Place getPlace(ResultSet result) throws SQLException {
        long placeId = result.getLong("placeid");
        String row = result.getString("row");
        long seat = result.getLong("seat");
        long classId = result.getLong("classId");
        String className = result.getString("className");
        String classDescr = result.getString("classDescr");
        FlightClass flightClass = new FlightClass(classId, className, classDescr);
        return new Place(placeId, row, seat, flightClass);
    }

    public int countPlacesByAircraftId(long aircraftId) throws SQLException {
        Statement stmt = ctx.getBean("statement", Statement.class);
        String formatSelectSearchFlight = ctx.getBean("formatSelectFlightPlaces", String.class);
        ResultSet result = null;
        int freePlaces = Integer.MIN_VALUE;
        result = stmt.executeQuery(String.format(formatSelectSearchFlight, aircraftId));
        while (result.next()) {
            freePlaces = result.getInt(1);
        }
        return freePlaces;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
