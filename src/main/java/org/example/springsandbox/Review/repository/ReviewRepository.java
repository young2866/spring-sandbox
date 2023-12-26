package org.example.springsandbox.Review.repository;

import org.example.springsandbox.Review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
