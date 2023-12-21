package org.example.springsandbox.User.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.dto.request.UserJoinRequestDto;
import org.example.springsandbox.User.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserJoinService {

	private final UserRepository userRepository;

	public Long join(UserJoinRequestDto userJoinRequestDto) {
		User user = userJoinRequestDto.toEntity();

		return userRepository.save(user).getId();
	}

}