package org.example.springsandbox.domain.repository;

import org.example.springsandbox.domain.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}