package org.example.springsandbox.User.api;


import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.User.application.UserFindService;
import org.example.springsandbox.User.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserFindApi {

	private final UserFindService userFindService;

	@PostMapping("/user/find")
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

	@GetMapping("/user/{nickname}")
	public String showUserProfile(@PathVariable String nickname, Model model) {
		Optional<User> user= userFindService.findByNickname(nickname);

		if (user.isPresent()) {
			model.addAttribute("user", user);
			return "user-profile";
		} else {
			return "redirect:/error";
		}
	}
}