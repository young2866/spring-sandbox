package org.example.springsandbox.User.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserDeleteApi {

	private final UserDeleteService userDeleteService;

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> userDelete(@PathVariable Long id) {
		userDeleteService.deleteUser(id);
		return ResponseEntity.ok().build();
	}


}