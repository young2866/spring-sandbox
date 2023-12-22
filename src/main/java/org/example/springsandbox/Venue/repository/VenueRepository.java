package org.example.springsandbox.Venue.repository;

import java.util.Optional;
import org.example.springsandbox.Venue.domain.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
	Optional<Venue> findByName(String name);

}
