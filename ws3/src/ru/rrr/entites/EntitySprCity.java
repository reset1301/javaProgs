package ru.rrr.entites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "spr_city", schema = "public", catalog = "airticket")
public class EntitySprCity {
    private long id;
    private String name;
    private String postcode;
    private int countryId;

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
        EntitySprCity that = (EntitySprCity) o;
        return id == that.id &&
                countryId == that.countryId &&
                Objects.equals(name, that.name) &&
                Objects.equals(postcode, that.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, postcode, countryId);
    }
}
