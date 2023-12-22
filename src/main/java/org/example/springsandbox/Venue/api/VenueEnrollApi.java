package org.example.springsandbox.Venue.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.application.VenueEnrollService;
import org.example.springsandbox.Venue.dto.request.VenueEnrollRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VenueEnrollApi {
	private final VenueEnrollService venueEnrollService;

	@PostMapping("/venue/enroll")
	public ResponseEntity<Long> venueEnroll(@RequestBody VenueEnrollRequestDto venueEnrollRequestDto) {
		Long sign = venueEnrollService.enroll(venueEnrollRequestDto);
		return ResponseEntity.ok(sign);
	}

}