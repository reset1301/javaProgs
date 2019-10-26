package hello.repo;

import hello.dto.FlightClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightClassRepo extends JpaRepository<FlightClassEntity,Long> {
}
