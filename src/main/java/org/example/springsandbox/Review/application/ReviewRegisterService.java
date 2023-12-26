package org.example.springsandbox.Review.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;
import org.example.springsandbox.Menu.repository.MenuRepository;
import org.example.springsandbox.Review.domain.Review;
import org.example.springsandbox.Review.dto.Request.ReviewRegisterRequestDto;
import org.example.springsandbox.Review.repository.ReviewRepository;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewRegisterService {
	private final ReviewRepository reviewRepository;
	private final UserRepository userRepository;
	private final MenuRepository menuRepository;

	public Long reviewRegister(ReviewRegisterRequestDto reviewRegisterRequestDto) {
		User user = userRepository.findById(reviewRegisterRequestDto.getUser_id())
			.orElseThrow(() -> new IllegalArgumentException("없는 유저 입니다."));
		Menu menu = menuRepository.findById(reviewRegisterRequestDto.getMenu_id())
			.orElseThrow(() -> new IllegalArgumentException("없는 메뉴 입니다."));

		Review review = reviewRegisterRequestDto.toEntity(reviewRegisterRequestDto.getScore(),
			user, menu);
		return reviewRepository.save(review).getId();
	}
}