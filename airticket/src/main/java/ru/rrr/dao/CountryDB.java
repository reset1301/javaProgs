package ru.rrr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rrr.entities.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("countryDB")
public class CountryDB {
    @Autowired
    private Statement statement;
    @Autowired
    private String selectCountryById;

    public Country getCountryById(long id) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format(selectCountryById, id));
        Country country = new Country();
        while (resultSet.next()) {
            country.setId(id);
            country.setFlag(resultSet.getString("flag"));
            country.setName(resultSet.getString("name"));
            country.setShortname(resultSet.getString("shortname"));
        }
        return country;
    }
}
