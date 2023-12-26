package org.example.springsandbox.Review.api;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Review.application.ReviewFindService;
import org.example.springsandbox.Review.domain.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewFindApi {
	private final ReviewFindService reviewFindService;

	@PostMapping("/venue/menu/review")
	public ResponseEntity<Review> findReview(@RequestBody Map<String, Long> JSON) {
		Long review_id = JSON.get("review_id");
		Optional<Review> optionalReview = reviewFindService.ReviewFindById(review_id);

		if (optionalReview.isPresent()) {
			Review review = optionalReview.get();
			return ResponseEntity.ok(review);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}