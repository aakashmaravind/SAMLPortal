package com.samlportal.samlportal.repository;

import com.samlportal.samlportal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndPassword(String name, String password);
}
