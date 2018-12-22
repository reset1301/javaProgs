package hello.repo;

import hello.dao.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepo extends JpaRepository<Organization,Long> {
    Optional<Organization> findById(Long id);
    List<Organization> findByName(String name);

    List<Organization> findByNameAndInn(String name, String inn);

    List<Organization> findByNameAndActive(String name, boolean isActive);

    List<Organization> findByNameAndInnAndActive(String name, String inn, boolean isActive);

    List<Organization> findById(long id);
}
