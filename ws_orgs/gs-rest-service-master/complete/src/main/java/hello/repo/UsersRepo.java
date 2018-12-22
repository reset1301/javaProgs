package hello.repo;

import hello.dao.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findById(long id);
//List<Users>findByOfficeAnd
}
