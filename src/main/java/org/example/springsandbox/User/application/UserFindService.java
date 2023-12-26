package org.example.springsandbox.User.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.dto.request.UserJoinRequestDto;
import org.example.springsandbox.User.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFindService {
	private final UserRepository userRepository;

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Optional<User> findById(Long Id) {
		return userRepository.findById(Id);
	}


}