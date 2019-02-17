package ru.rrr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rrr.entities.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("cityDB")
public class CityDB /*implements ApplicationContextAware*/ {
    @Autowired
    private String selectCityById;
    @Autowired
    private Statement statement;
    @Autowired
    private CountryDB countryDB;


    public City getCityById(long id) throws SQLException {
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(String.format(selectCityById, id));
        City city = new City();
        while (resultSet.next()) {
            city.setId(id);
            city.setCountry(countryDB.getCountryById(resultSet.getLong("country_id")));
            city.setName(resultSet.getString("name"));
            city.setPostcode(resultSet.getString("postcode"));
        }
        return city;
    }
}
