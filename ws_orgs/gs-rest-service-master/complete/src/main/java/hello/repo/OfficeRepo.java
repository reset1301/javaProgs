package hello.repo;

import hello.dao.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeRepo extends JpaRepository<Office, Long> {
    List<Office> findByOrganization_Id(long id);

    List<Office> findByOrganization_IdAndName(long id, String name);

    List<Office> findByOrganization_IdAndPhone(long id, String phone);

    List<Office> findByOrganization_IdAndActive(long id, boolean isActive);

    List<Office> findByOrganization_IdAndNameAndPhone(long id, String name, String phone);

    List<Office> findByOrganization_IdAndNameAndActive(long id, String name, boolean isActive);

    List<Office> findByOrganization_IdAndPhoneAndActive(long id, String phone, boolean isActive);

    List<Office> findByOrganization_IdAndNameAndPhoneAndActive(long id, String name, String phone, boolean isActive);

    List<Office> findById(long id);
}
