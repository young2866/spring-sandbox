package org.example.springsandbox.User.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.dto.request.UserJoinRequestDto;
import org.example.springsandbox.User.dto.request.UserUpdateRequestDto;
import org.example.springsandbox.User.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

	private final UserRepository userRepository;

	public Long update(Long id, UserUpdateRequestDto userUpdateRequestDto) {

		Optional<User> user = userRepository.findById(id);

		if(user.isPresent()) {
			User updateUser = user.get();

			if (userRepository.findByNickname(userUpdateRequestDto.getNickname()).isPresent()) {
				throw new IllegalArgumentException("중복되는 닉네임입니다.");
			}
			updateUser.update(userUpdateRequestDto.getPassword()
				, userUpdateRequestDto.getNickname());

			return userRepository.save(updateUser).getId();
		}else {
			// ID에 해당하는 사용자를 찾지 못한 경우 404 응답
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}

}