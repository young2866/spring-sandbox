package org.example.springsandbox.Review.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Review.domain.Review;
import org.example.springsandbox.Review.dto.Request.ReviewUpdateRequestDto;
import org.example.springsandbox.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewUpdateService {

	private final ReviewRepository reviewRepository;

	public Long reviewUpdate(Long id, ReviewUpdateRequestDto reviewUpdateRequestDto) {
		Optional<Review> optionalReview = reviewRepository.findById(id);

		if (optionalReview.isPresent()) {
			Review review = optionalReview.get();
			review.update(reviewUpdateRequestDto.getScore());
			return reviewRepository.save(review).getId();
		} else {
			throw new IllegalArgumentException("해당 되는 리뷰가 없습니다.");
		}
	}

}