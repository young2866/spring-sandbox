package org.example.springsandbox.Venue.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.application.VenueUpdateService;
import org.example.springsandbox.Venue.dto.request.VenueUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VenueUpdateApi {
	private final VenueUpdateService venueUpdateService;

	@PutMapping("/venue/{id}")
	public ResponseEntity<Long> update(@PathVariable Long id
		, @RequestBody VenueUpdateRequestDto venueUpdateRequestDto) {

		Long sign = venueUpdateService.update(id, venueUpdateRequestDto);
		return ResponseEntity.ok(sign);
	}

}