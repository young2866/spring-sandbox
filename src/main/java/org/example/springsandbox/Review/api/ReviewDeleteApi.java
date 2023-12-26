package org.example.springsandbox.Review.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Review.application.ReviewDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewDeleteApi {

	private final ReviewDeleteService reviewDeleteService;

	@DeleteMapping("/venue/menu/review/{id}")
	public ResponseEntity<Long> deleteReview(@PathVariable Long id) {
		reviewDeleteService.deleteReview(id);
		return ResponseEntity.ok().build();
	}

}