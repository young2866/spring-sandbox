package org.example.springsandbox.Venue.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.application.VenueDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VenueDeleteApi {

	private final VenueDeleteService venueDeleteService;

	@DeleteMapping("/venue/{id}")
	public ResponseEntity<Void> venueDelete(@PathVariable Long id) {
		venueDeleteService.deleteVenue(id);
		return ResponseEntity.ok().build();
	}

}