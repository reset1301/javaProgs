package hello.repo;

import hello.dao.Docs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocsRepo extends JpaRepository<Docs, Long> {
    List<Docs> findAll();

    List<Docs> findByName(String docName);
}
