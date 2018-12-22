package ru.rrr.generated_entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "spr_aircraft", schema = "public", catalog = "airticket")
public class SprAircraftEntity {
    private long id;
    private String name;
    private long companyId;
    private Collection<FlightEntity> flightsById;
    private SprCompanyEntity sprCompanyByCompanyId;
    private Collection<SprAircraftPlaceEntity> sprAircraftPlacesById;

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
    @Column(name = "company_id", nullable = false)
    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprAircraftEntity that = (SprAircraftEntity) o;
        return id == that.id &&
                companyId == that.companyId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, companyId);
    }

    @OneToMany(mappedBy = "sprAircraftByAircraftId")
    public Collection<FlightEntity> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(Collection<FlightEntity> flightsById) {
        this.flightsById = flightsById;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    public SprCompanyEntity getSprCompanyByCompanyId() {
        return sprCompanyByCompanyId;
    }

    public void setSprCompanyByCompanyId(SprCompanyEntity sprCompanyByCompanyId) {
        this.sprCompanyByCompanyId = sprCompanyByCompanyId;
    }

    @OneToMany(mappedBy = "sprAircraftByAircraftId")
    public Collection<SprAircraftPlaceEntity> getSprAircraftPlacesById() {
        return sprAircraftPlacesById;
    }

    public void setSprAircraftPlacesById(Collection<SprAircraftPlaceEntity> sprAircraftPlacesById) {
        this.sprAircraftPlacesById = sprAircraftPlacesById;
    }
}
