package ru.rrr.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.rrr.entities.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("companyDB")
public class CompanyDB implements ApplicationContextAware {
    private ApplicationContext ctx;

    public Company getCompanyById(long id) throws SQLException {
        String selectCompanyById = (String) ctx.getBean("selectCompanyById");
        Statement statement = ctx.getBean("statement", Statement.class);
        ResultSet resultSet = statement.executeQuery(String.format(selectCompanyById, id));
        Company company = new Company();
        while (resultSet.next()) {
            company.setId(id);
            company.setName(resultSet.getString("name"));
            company.setDescr(resultSet.getString("descr"));
        }
        return company;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
