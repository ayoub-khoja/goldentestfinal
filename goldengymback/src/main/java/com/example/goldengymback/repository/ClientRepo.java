package com.example.goldengymback.repository;

import com.example.goldengymback.model.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepo extends JpaRepository<client, Long> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM client c WHERE c.name = :name AND c.password = :password")
    boolean findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
