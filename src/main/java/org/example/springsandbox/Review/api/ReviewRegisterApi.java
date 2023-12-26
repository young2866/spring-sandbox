package org.example.springsandbox.Review.api;


import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Review.application.ReviewRegisterService;
import org.example.springsandbox.Review.dto.Request.ReviewRegisterRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewRegisterApi {
	private final ReviewRegisterService reviewRegisterService;

	@PostMapping("/venue/menu/review/register")
	public ResponseEntity<Long> registerReview(
		@RequestBody ReviewRegisterRequestDto reviewRegisterRequestDto) {
		Long sign = reviewRegisterService.reviewRegister(reviewRegisterRequestDto);
		return ResponseEntity.ok(sign);
	}
}