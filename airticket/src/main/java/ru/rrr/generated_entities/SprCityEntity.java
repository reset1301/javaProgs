package ru.rrr.generated_entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "spr_city", schema = "public", catalog = "airticket")
public class SprCityEntity {
    private long id;
    private String name;
    private String postcode;
    private int countryId;
    private Collection<FlightEntity> flightsById;
    private Collection<FlightEntity> flightsById_0;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "postcode", nullable = false, length = 255)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "country_id", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprCityEntity that = (SprCityEntity) o;
        return id == that.id &&
                countryId == that.countryId &&
                Objects.equals(name, that.name) &&
                Objects.equals(postcode, that.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, postcode, countryId);
    }

    @OneToMany(mappedBy = "sprCityByCityFromId")
    public Collection<FlightEntity> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(Collection<FlightEntity> flightsById) {
        this.flightsById = flightsById;
    }

    @OneToMany(mappedBy = "sprCityByCityToId")
    public Collection<FlightEntity> getFlightsById_0() {
        return flightsById_0;
    }

    public void setFlightsById_0(Collection<FlightEntity> flightsById_0) {
        this.flightsById_0 = flightsById_0;
    }
}
