package org.example.springsandbox.User.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserJoinService;
import org.example.springsandbox.User.dto.request.UserJoinRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserJoinApi {
	private final UserJoinService userJoinService;

	@PostMapping("/user/join")
	public ResponseEntity<Long> userJoin(@RequestBody UserJoinRequestDto userJoinRequestDto) {
		Long sign = userJoinService.join(userJoinRequestDto);
		return ResponseEntity.ok(sign);
	}

}