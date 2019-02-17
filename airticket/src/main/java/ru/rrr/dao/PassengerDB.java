package ru.rrr.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.rrr.entities.Passenger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("passengerDB")
public class PassengerDB {
    @Autowired
    private Statement statement;
    @Autowired
    private String selectPassengerById;

    public Passenger getPassengerById(long id) throws SQLException {
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(String.format(selectPassengerById, id));
        Passenger passenger = new Passenger();
        while (resultSet.next()) {
            passenger.setId(resultSet.getLong("id"));
            passenger.setDocumentNumber(resultSet.getString("document_number"));
            passenger.setGivenname(resultSet.getString("given_name"));
            passenger.setMiddlename(resultSet.getString("middle_name"));
            passenger.setFamilyname(resultSet.getString("family_name"));
            passenger.setEmail(resultSet.getString("email"));
            passenger.setPhone(resultSet.getString("phone"));
        }
        return passenger;
    }
}
