package ru.rrr.model;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.rrr.service_interfaces.Search;
import ru.rrr.config.HibernateSessionFactory;
import ru.rrr.entities.City;
import ru.rrr.entities.Flight;
import ru.rrr.generated_entities.SprCountryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Slf4j
public class SearchImplHibernate implements Search/*, ApplicationContextAware*/ {
    public SearchImplHibernate() {
    }

    @Override
    public List<Flight> searchFlight(long date, City cityFrom, City cityTo, int placeCount) {
        return null;
    }
}
