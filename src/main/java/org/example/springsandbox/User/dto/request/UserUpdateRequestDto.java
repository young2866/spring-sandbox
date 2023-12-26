package org.example.springsandbox.User.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.User.domain.User;

@NoArgsConstructor
@Getter
public class UserUpdateRequestDto {
	private String nickname;
	private String password;

	@Builder
	public UserUpdateRequestDto(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
	}

	public User toEntity() {
		return User.builder()
			.nickname(nickname)
			.password(password)
			.build();
	}

}