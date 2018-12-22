package hello.repo;

import hello.dao.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PositionRepo extends JpaRepository<Position, Long> {
    @Override
    Optional<Position> findById(Long id);

    List<Position> findByName(String name);
}
