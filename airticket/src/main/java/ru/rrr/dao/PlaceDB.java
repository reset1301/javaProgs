package ru.rrr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rrr.entities.FlightClass;
import ru.rrr.entities.Place;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component("placeDB")
public class PlaceDB {
    @Autowired
    private Statement statement;
    @Autowired
    private String selectReservedPlaces;
    @Autowired
    private FlightClassDB flightClassDB;
    @Autowired
    private String selectFlightPlaces;
    @Autowired
    private String formatSelectFlightPlaces;

    public Place getPlaceById(long id) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format(selectReservedPlaces, id));
        Place place = new Place();
        while (resultSet.next()) {
            place.setId(resultSet.getLong("id"));
            place.setRow(resultSet.getString("row"));
            place.setSeat(resultSet.getLong("seat"));
            place.setFlightClass(flightClassDB.getFlightClassById(resultSet.getLong("flight_class_id")));
        }
        return place;
    }

    public List<Place> getPlacesByAircraftId(long aircraftId) throws SQLException {
        ResultSet result1 = null;
        try {
            result1 = statement.executeQuery(String.format(selectFlightPlaces, aircraftId));
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
        ResultSet result = null;
        int freePlaces = Integer.MIN_VALUE;
        result = statement.executeQuery(String.format(formatSelectFlightPlaces, aircraftId));
        while (result.next()) {
            freePlaces = result.getInt(1);
        }
        return freePlaces;
    }
}
