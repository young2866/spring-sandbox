package org.example.springsandbox.domain.repository;

import org.example.springsandbox.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}