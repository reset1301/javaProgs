package hello.repo;

import hello.dao.Office;
import hello.dao.Position;
import hello.dao.UserDoc;
import hello.dao.Users;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersClass {
    private EntityManager em;

    @Autowired
    public UsersClass(EntityManager em) {
        this.em = em;
    }

    public List<Users> getUserList(long officeId, String firstName,
                            String lastName, String middleName,
                            Long positionId, Long userdocId,
                            Long citizenshipCode) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Users> cq = criteriaBuilder.createQuery(Users.class);
        Root<Users> usersRoot = cq.from(Users.class);
        cq.select(usersRoot);
        List<Predicate> predicates = new ArrayList<>();
        Predicate office = criteriaBuilder.equal(usersRoot.get("office").get("id"), officeId);
        predicates.add(office);
        if (firstName != null) {
            predicates.add(criteriaBuilder.equal(usersRoot.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(criteriaBuilder.equal(usersRoot.get("secondName"), lastName));
        }
        if (middleName != null) {
            predicates.add(criteriaBuilder.equal(usersRoot.get("middleName"), middleName));
        }
        if (positionId != null) {
            predicates.add(criteriaBuilder.equal(usersRoot.get("position").get("id"), positionId));
        }
        if (userdocId != null) {
            predicates.add(criteriaBuilder.equal(usersRoot.get("userDoc").get("id"), userdocId));
        }
        if (citizenshipCode != null) {
            predicates.add(criteriaBuilder.equal(usersRoot.get("citizenshipCode"), citizenshipCode));
        }
        cq.where(predicates.toArray(new Predicate[predicates.size()]));
        TypedQuery<Users> q = em.createQuery(cq);
        List<Users> users = q.getResultList();

        return users;
    }

}
