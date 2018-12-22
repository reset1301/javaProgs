package ru.rrr.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
@Slf4j
@PropertySource("classpath:aircraft.properties")
@ComponentScan(basePackages = "ru.rrr")
public class AppConfig {
    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @Value("${spring.datasource.username}")
    private String datasourceUsername;
    @Value("${spring.datasource.password}")
    private String datasourcePassword;
    @Value("${spring.db.driver}")
    private String dbDriver;
    @Value("${search.flight.select}")
    private String formatSelectSearchFlight;
    @Value("${search.flight.places}")
    private String formatSelectFlightPlaces;
    @Value("${select.flight.places}")
    private String selectFlightPlaces;
    @Value("${select.reservation.by.flight}")
    private String selectReservationByFlight;
    @Value("${select.reserved.places.by.id}")
    private String selectReservedPlaces;
    @Value("${select.flight.class.by.id}")
    private String selectFlightClass;
    @Value("${select.passenger.by.id}")
    private String selectPassengerById;
    @Value("${select.flight.by.id}")
    private String selectFlightById;
    @Value("${select.city.by.id}")
    private String selectCityById;
    @Value("${select.country.by.id}")
    private String selectCountryById;
    @Value("${select.aircraft.by.id}")
    private String selectAircraftById;
    @Value("${select.company.by.id}")
    private String selectCompanyById;

    @Bean(name = "selectFlightPlaces")
    @Scope(value = "singleton")
    public String getSelectFlightPlaces() {
        return selectFlightPlaces;
    }

    @Bean(name = "formatSelectFlightPlaces")
    @Scope(value = "singleton")
    public String getFormatSelectFlightPlaces() {
        return formatSelectFlightPlaces;
    }

    @Bean(name = "formatSelectSearchFlight")
    @Scope(value = "singleton")
    public String getFormatSelectSearchFlight() {
        return formatSelectSearchFlight;
    }

    @Bean(name = "statement")
    @Scope(value = "prototype")
    public Statement getStatementToDb() {
        try {
//            Class.forName("org.postgresql.Driver");
            Class.forName(dbDriver);
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/airticket", "postgres", "postgres");
            Connection connection = DriverManager.getConnection(
                    datasourceUrl, datasourceUsername, datasourcePassword
            );
            log.info("Connection is created.");
            return connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            log.error("Creation connection error occurs: " + e.getMessage());
            return null;
        }
    }

    @Bean(name = "selectReservationByFlight")
    @Scope(value = "singleton")
    public String getSelectReservationByFlight() {
        return selectReservationByFlight;
    }

    @Bean(name = "selectReservedPlaces")
    @Scope(value = "singleton")
    public String getSelectReservedPlaces() {
        return selectReservedPlaces;
    }

    @Bean(name = "selectFlightClass")
    @Scope(value = "singleton")
    public String getSelectFlightClass() {
        return selectFlightClass;
    }

    @Bean(name = "selectPassengerById")
    @Scope(value = "singleton")
    public String getSelectPassengerById() {
        return selectPassengerById;
    }

    @Bean(name = "selectFlightById")
    @Scope(value = "singleton")
    public String getSelectFlightById() {
        return selectFlightById;
    }

    @Bean(name = "selectCityById")
    @Scope(value = "singleton")
    public String getSelectCityById() {
        return selectCityById;
    }

    @Bean(name = "selectCountryById")
    @Scope(value = "singleton")
    public String getSelectCountryById() {
        return selectCountryById;
    }

    @Bean(name = "selectAircraftById")
    @Scope(value = "singleton")
    public String getSelectAircraftById() {
        return selectAircraftById;
    }

    @Bean(name = "selectCompanyById")
    @Scope(value = "singleton")
    public String getSelectCompanyById() {
        return selectCompanyById;
    }

}
