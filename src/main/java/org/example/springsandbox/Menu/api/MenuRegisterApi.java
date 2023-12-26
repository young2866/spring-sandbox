package org.example.springsandbox.Menu.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.application.MenuRegisterService;
import org.example.springsandbox.Menu.dto.Request.MenuRegisterRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuRegisterApi {
	private final MenuRegisterService menuRegisterService;

	@PostMapping("/venue/menu/register")
	public ResponseEntity<Long> menuRegister(@RequestBody MenuRegisterRequestDto menuRegisterRequestDto) {
		Long sign = menuRegisterService.register(menuRegisterRequestDto);
		return ResponseEntity.ok(sign);
	}

}