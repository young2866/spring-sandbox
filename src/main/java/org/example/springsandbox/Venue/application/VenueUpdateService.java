package org.example.springsandbox.Venue.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.dto.request.VenueUpdateRequestDto;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor

public class VenueUpdateService {
	private final VenueRepository venueRepository;

	public Long update(Long id, VenueUpdateRequestDto venueUpdateRequestDto) {

		Optional<Venue> venue = venueRepository.findById(id);

		if(venue.isPresent()) {
			Venue updateVenue = venue.get();
			updateVenue.update(venueUpdateRequestDto.getName()
				,venueUpdateRequestDto.getPhoneNumber());

			return venueRepository.save(updateVenue).getId();
		}else {
			// ID에 해당하는 사용자를 찾지 못한 경우 404 응답
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
}