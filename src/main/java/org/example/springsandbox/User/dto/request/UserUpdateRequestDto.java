package org.example.springsandbox.User.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.User.domain.User;

@NoArgsConstructor
@Getter
public class UserUpdateRequestDto {

	private String currentPassword;
	private String newPassword;

}