package org.example.springsandbox.Review.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Review.domain.Review;
import org.example.springsandbox.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewFindService {

	private final ReviewRepository reviewRepository;

	public Optional<Review> ReviewFindById(Long id) {
		return reviewRepository.findById(id);
	}

}