package hello.repo;

import hello.dao.Countries;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountriesRepo extends CrudRepository<Countries, Long> {
    List<Countries> findAll();
}
