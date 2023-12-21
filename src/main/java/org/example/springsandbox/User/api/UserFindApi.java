package org.example.springsandbox.User.api;


import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserFindService;
import org.example.springsandbox.User.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserFindApi {

	private final UserFindService userFindService;

	@PostMapping("/find")
	@ResponseBody
	public ResponseEntity<User> userFind(@RequestBody Map<String, String> request) {
		String email = request.get("email");

		Optional<User> userOptional = userFindService.findByEmail(email);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			return ResponseEntity.ok(user);
		} else {
			// Optional이 비어있을 경우
			return ResponseEntity.notFound().build();
		}
	}
}