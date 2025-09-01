package com.samlportal.samlportal.repository;

import com.samlportal.samlportal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByNameAndPasswordAndRole(String name, String password, String role);

    Optional<Users> findByEmail(String email);
}
