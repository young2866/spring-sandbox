package org.example.springsandbox.User.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.domain.User;
import org.example.springsandbox.User.dto.request.UserJoinRequestDto;
import org.example.springsandbox.User.dto.request.UserUpdateRequestDto;
import org.example.springsandbox.User.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public Long update(Long id, UserUpdateRequestDto userUpdateRequestDto) {

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {
			User updateUser = user.get();

			// 현재 비밀번호와 저장된 비밀번호 일치 여부 확인
			if (!passwordEncoder.matches(userUpdateRequestDto.getCurrentPassword(),
				updateUser.getPassword())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Current password is incorrect");
			}

			// 새로운 비밀번호와 현재 비밀번호 일치 여부 확인
			if (userUpdateRequestDto.getNewPassword().equals(userUpdateRequestDto.getCurrentPassword())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"New password should be different from the current password");
			}

			// 새로운 비밀번호로 업데이트하고 저장
			updateUser.update(userUpdateRequestDto.getNewPassword());
			updateUser.hashPassword(passwordEncoder);

			return userRepository.save(updateUser).getId();
		} else {
			// ID에 해당하는 사용자를 찾지 못한 경우 404 응답
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}
}
