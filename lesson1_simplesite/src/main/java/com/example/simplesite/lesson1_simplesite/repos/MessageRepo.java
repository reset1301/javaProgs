package com.example.simplesite.lesson1_simplesite.repos;

import com.example.simplesite.lesson1_simplesite.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
