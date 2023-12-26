package org.example.springsandbox.Menu.repository;

import org.example.springsandbox.Menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}