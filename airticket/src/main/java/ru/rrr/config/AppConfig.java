package ru.rrr.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

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
}
