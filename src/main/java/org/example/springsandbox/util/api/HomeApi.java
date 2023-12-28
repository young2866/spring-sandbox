package org.example.springsandbox.util.api;

import java.util.Optional;
import org.example.springsandbox.User.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeApi {

	@GetMapping("/home")
	public String home(Model model, @AuthenticationPrincipal User user) {
		if (user != null) {
			// 사용자가 인증된 경우
			model.addAttribute("nickname", user.getNickname());
		}
		// 인증 상태와 관계없이 로그인/로그아웃 버튼을 표시
		model.addAttribute("authenticated", user != null);

		return "home";
	}
}
