package org.example.springsandbox.User.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.dto.request.UserJoinRequestDto;
import org.example.springsandbox.User.repository.UserRepository;
import org.example.springsandbox.util.config.UserPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;


	public Long signUp(UserJoinRequestDto userJoinRequestDto) {
		User user = userJoinRequestDto.toEntity();
		user.hashPassword(passwordEncoder);

		return userRepository.save(user).getId();
	}

}