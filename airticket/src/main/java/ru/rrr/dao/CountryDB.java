package ru.rrr.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.entities.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("countryDB")
public class CountryDB implements ApplicationContextAware {
    private ApplicationContext ctx;

    public Country getCountryById(long id) throws SQLException {
        String selectCountryById = (String) ctx.getBean("selectCountryById");
        Statement statement = ctx.getBean("statement", Statement.class);
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
