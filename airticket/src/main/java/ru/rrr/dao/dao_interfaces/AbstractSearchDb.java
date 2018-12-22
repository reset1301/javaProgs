package ru.rrr.dao.dao_interfaces;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component("selectToDB")
public  class AbstractSearchDb implements ApplicationContextAware {
    private ApplicationContext ctx;
    private Statement statement;
//    private AbstractSearchDb abstractSearchDb;

    @PostConstruct
    private void init() {
        statement = (Statement) ctx.getBean("statement");
    }

    public ResultSet getObjectById(String select, long id) throws SQLException {
//        Statement statement = ctx.getBean("statement", Statement.class);
        return statement.executeQuery(String.format(select, id));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

}
