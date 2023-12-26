package org.example.springsandbox.User.repository;

import java.util.Optional;
import org.example.springsandbox.User.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}