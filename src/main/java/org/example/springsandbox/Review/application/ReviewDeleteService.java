package org.example.springsandbox.Review.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Review.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@RequiredArgsConstructor
@Service
public class ReviewDeleteService {

	private final ReviewRepository reviewRepository;

	public void deleteReview(Long id) {
		reviewRepository.deleteById(id);
	}

}