package ru.rrr.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.entities.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Component("cityDB")
public class CityDB implements ApplicationContextAware {
    private ApplicationContext ctx;

    public City getCityById(long id) throws SQLException {
        String selectCityById = (String) ctx.getBean("selectCityById");
        Statement statement = ctx.getBean("statement", Statement.class);
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(String.format(selectCityById, id));
        City city = new City();
        while (resultSet.next()) {
            city.setId(id);
            CountryDB countryDB = ctx.getBean("countryDB", CountryDB.class);
            city.setCountry(countryDB.getCountryById(resultSet.getLong("country_id")));
            city.setName(resultSet.getString("name"));
            city.setPostcode(resultSet.getString("postcode"));
        }
        return city;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
