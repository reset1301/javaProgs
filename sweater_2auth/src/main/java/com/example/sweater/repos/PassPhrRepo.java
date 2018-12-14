package com.example.sweater.repos;

import com.example.sweater.domain.PassPhr;
import com.example.sweater.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassPhrRepo extends JpaRepository<PassPhr, Long> {
    PassPhr findByPassPhrase(String passPhr);
}
