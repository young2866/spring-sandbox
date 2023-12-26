package org.example.springsandbox.Venue.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.dto.request.VenueEnrollRequestDto;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VenueEnrollService {

	private final VenueRepository venueRepository;

	public Long enroll(VenueEnrollRequestDto venueEnrollRequestDto) {
		Venue venue =  venueEnrollRequestDto.toEntity();

		return venueRepository.save(venue).getId();
	}
}