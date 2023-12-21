package org.example.springsandbox.User.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserUpdateService;
import org.example.springsandbox.User.dto.request.UserUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserUpdateApi {

	private final UserUpdateService userUpdateService;

	@PutMapping("/user/{id}")
	public ResponseEntity<Long> update(@PathVariable Long id
		, @RequestBody UserUpdateRequestDto userUpdateRequestDto) {

		Long sign = userUpdateService.update(id, userUpdateRequestDto);
		return ResponseEntity.ok(sign);
	}

}