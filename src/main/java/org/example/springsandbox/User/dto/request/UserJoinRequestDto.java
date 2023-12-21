package org.example.springsandbox.User.dto.request;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.User.domain.User;

@NoArgsConstructor
@Getter
public class UserJoinRequestDto {

	private String email;
	private String nickname;
	private String password;
	private String phoneNumber;

	@Builder
	public UserJoinRequestDto(String email, String nickname, String password, String phoneNumber) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public User toEntity() {
		return User.builder()
			.email(email)
			.nickname(nickname)
			.password(password)
			.phoneNumber(phoneNumber)
			.build();
	}
}