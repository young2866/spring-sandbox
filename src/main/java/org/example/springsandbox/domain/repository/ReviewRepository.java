package org.example.springsandbox.domain.repository;

import org.example.springsandbox.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
