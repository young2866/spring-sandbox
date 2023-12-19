package org.example.springsandbox.domain.repository;

import org.example.springsandbox.domain.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}
