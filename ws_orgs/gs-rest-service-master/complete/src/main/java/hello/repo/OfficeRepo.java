package hello.repo;

import hello.dao.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfficeRepo extends JpaRepository<Office, Long> {
    List<Office> findByOrganization_Id(long id);

    List<Office> findByOrganization_IdAndName(Long id, String name);

    List<Office> findByOrganization_IdAndPhone(Long id, String phone);

    List<Office> findByOrganization_IdAndActive(Long id, boolean isActive);

    List<Office> findByOrganization_IdAndNameAndPhone(Long id, String name, String phone);

    List<Office> findByOrganization_IdAndNameAndActive(Long id, String name, boolean isActive);

    List<Office> findByOrganization_IdAndPhoneAndActive(Long id, String phone, boolean isActive);

    List<Office> findByOrganization_IdAndNameAndPhoneAndActive(Long id, String name, String phone, boolean isActive);

    Optional<Office> findById(Long id);
}
