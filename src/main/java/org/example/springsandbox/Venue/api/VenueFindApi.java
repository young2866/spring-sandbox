package org.example.springsandbox.Venue.api;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Venue.application.VenueFindService;
import org.example.springsandbox.Venue.domain.Venue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VenueFindApi {

	private final VenueFindService venueFindService;

	@PostMapping("/venue")
	public ResponseEntity<Venue> venueFind(@RequestBody Map<String, String> request) {
		String venueName = request.get("name");
		Optional<Venue> venueOptional = venueFindService.findByName(venueName);

		if (venueOptional.isPresent()) {
			Venue venue = venueOptional.get();
			return ResponseEntity.ok(venue);
		} else {
			// Optional이 비어있을 경우
			return ResponseEntity.notFound().build();
		}
	}
}