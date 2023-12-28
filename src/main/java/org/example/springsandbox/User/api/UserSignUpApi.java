package org.example.springsandbox.User.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserSignUpService;
import org.example.springsandbox.User.dto.request.UserJoinRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserSignUpApi {
	private final UserSignUpService userSignUpService;

	@PostMapping("/signup")
	public ResponseEntity<Long> userJoin(@RequestBody UserJoinRequestDto userJoinRequestDto) {
		Long sign = userSignUpService.signUp(userJoinRequestDto);
		return ResponseEntity.ok(sign);
	}

}