package org.example.springsandbox.User.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserUpdateService;
import org.example.springsandbox.User.dto.request.UserUpdateRequestDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserUpdateApi {

	private final UserUpdateService userUpdateService;

	@PutMapping("/user/{id}")
	public Long update(@PathVariable Long id
		, @RequestBody UserUpdateRequestDto userUpdateRequestDto) {

		return userUpdateService.update(id, userUpdateRequestDto);

	}

}