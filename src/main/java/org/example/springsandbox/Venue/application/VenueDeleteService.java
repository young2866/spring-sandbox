package org.example.springsandbox.Venue.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VenueDeleteService {

	private final VenueRepository venueRepository;

	public void deleteVenue(Long id) {
		venueRepository.deleteById(id);
	}
}