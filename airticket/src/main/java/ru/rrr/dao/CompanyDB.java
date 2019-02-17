package ru.rrr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rrr.entities.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("companyDB")
public class CompanyDB {
    @Autowired
    private String selectCompanyById;
    @Autowired
    private Statement statement;

    public Company getCompanyById(long id) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format(selectCompanyById, id));
        Company company = new Company();
        while (resultSet.next()) {
            company.setId(id);
            company.setName(resultSet.getString("name"));
            company.setDescr(resultSet.getString("descr"));
        }
        return company;
    }
}
