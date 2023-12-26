package org.example.springsandbox.Review.dto.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Review.domain.Review;

@Getter
@NoArgsConstructor
public class ReviewUpdateRequestDto {

	private float score;

	@Builder
	public ReviewUpdateRequestDto(float score) {
		this.score = score;
	}

	public Review toEntity(float score) {
		return Review.builder()
			.score(score)
			.build();
	}
}