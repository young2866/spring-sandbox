package org.example.springsandbox.User.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username)
			.orElseThrow(() -> new IllegalArgumentException(username));
		return User.builder()
			.id(user.getId())
			.nickname(user.getNickname())
			.password(user.getPassword())
			.phoneNumber(user.getPhoneNumber())
			.email(user.getEmail())
			.reviewList(user.getReviewList())
			.build();
	}

}