package org.example.springsandbox.User.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserLoginService;
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
	private final UserLoginService userLoginService;

	@PostMapping("/signup")
	public ResponseEntity<String> userJoin(@RequestBody UserJoinRequestDto userJoinRequestDto) {
		userSignUpService.signUp(userJoinRequestDto);

		return ResponseEntity.ok("{\"message\": \"success\"}");
	}

}