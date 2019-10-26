package hello.controller;

import hello.dto.FlightClassEntity;
import hello.repo.FlightClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightClassRepo repo;

    @GetMapping("/")
    public List<FlightClassEntity> getAll() {
        return repo.findAll();
    }
}
