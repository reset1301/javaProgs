package ru.rrr.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.entities.FlightClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("flightClassDB")
public class FlightClassDB  {
    @Autowired
    private String selectFlightClass;
    @Autowired
    private Statement statement;
    public FlightClass getFlightClassById(long id) throws SQLException {
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(String.format(selectFlightClass, id));
        FlightClass flightClass = new FlightClass();
        while (resultSet.next()) {
            flightClass.setDescr(resultSet.getString("descr"));
            flightClass.setId(resultSet.getLong("id"));
            flightClass.setName("name");
        }
        return flightClass;
    }
}
