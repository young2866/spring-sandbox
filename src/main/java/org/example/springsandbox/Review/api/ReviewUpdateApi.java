package org.example.springsandbox.Review.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Review.application.ReviewUpdateService;
import org.example.springsandbox.Review.dto.Request.ReviewUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewUpdateApi {

	private final ReviewUpdateService reviewUpdateService;

	@PutMapping("/venue/menu/review/{id}")
	public ResponseEntity<Long> update(@PathVariable Long id,
		@RequestBody ReviewUpdateRequestDto reviewUpdateRequestDto) {

		Long update = reviewUpdateService.reviewUpdate(id, reviewUpdateRequestDto);

		return ResponseEntity.ok(update);
	}
}