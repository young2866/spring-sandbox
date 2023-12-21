package org.example.springsandbox.User.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

	private final UserRepository userRepository;

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}