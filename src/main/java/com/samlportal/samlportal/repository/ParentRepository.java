package com.samlportal.samlportal.repository;

import com.samlportal.samlportal.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Optional<Parent> findByNameAndPassword(String name, String password);
}

