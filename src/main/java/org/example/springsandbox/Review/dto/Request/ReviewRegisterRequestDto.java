package org.example.springsandbox.Review.dto.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;
import org.example.springsandbox.Review.domain.Review;
import org.example.springsandbox.User.domain.User;

@NoArgsConstructor
@Getter
public class ReviewRegisterRequestDto {

	private float score;
	private Long user_id;
	private Long menu_id;

	@Builder
	public ReviewRegisterRequestDto(float score, Long user_id, Long menu_id) {
		this.score = score;
		this.user_id = user_id;
		this.menu_id = menu_id;
	}

	public Review toEntity(float score, User user, Menu menu) {
		return Review.builder()
			.score(score)
			.user(user)
			.menu(menu)
			.build();
	}
}