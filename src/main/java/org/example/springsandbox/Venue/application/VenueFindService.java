package org.example.springsandbox.Venue.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VenueFindService {
	private final VenueRepository venueRepository;

	public Optional<Venue> findByName(String name) {
		return venueRepository.findByName(name);
	}

}