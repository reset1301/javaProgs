package hello.repo;

import hello.dao.UserDoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDocRepo extends JpaRepository<UserDoc,Long> {
}
