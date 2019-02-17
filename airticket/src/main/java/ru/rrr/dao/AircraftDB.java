package ru.rrr.dao;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.entities.Aircraft;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("aircraftDB")
public class AircraftDB /*implements ApplicationContextAware*/ {
    //    private ApplicationContext ctx;
    @Autowired
    private Statement statement;
    @Autowired
    private String selectAircraftById;
    @Autowired
    private CompanyDB companyDB;
    @Autowired
    private PlaceDB placeDB;

    public Aircraft getAircraftById(long id) throws SQLException {
//        String selectAircraftById = (String) ctx.getBean("selectAircraftById");
//        Statement statement = ctx.getBean("statement", Statement.class);

        ResultSet resultSet = statement.executeQuery(String.format(selectAircraftById, id));
        Aircraft aircraft = new Aircraft();
        while (resultSet.next()) {
            aircraft.setId(id);
            aircraft.setName(resultSet.getString("name"));
//            CompanyDB companyDB = ctx.getBean("companyDB", CompanyDB.class);
            aircraft.setCompany(companyDB.getCompanyById(resultSet.getLong("company_id")));
//            PlaceDB placeDB = (PlaceDB) ctx.getBean("placeDB");
            aircraft.setPlaces(placeDB.getPlacesByAircraftId(id));
        }
        return aircraft;
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        ctx = applicationContext;
//    }
}
