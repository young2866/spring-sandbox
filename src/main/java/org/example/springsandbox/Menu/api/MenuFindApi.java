package org.example.springsandbox.Menu.api;

import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.application.MenuFindService;
import org.example.springsandbox.Menu.domain.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuFindApi {
	private final MenuFindService menuFindService;

	@PostMapping("/venue/menu")
	public ResponseEntity<Menu> menuFindById(@RequestBody Map<String, Long> JSON) {
		Long id = JSON.get("id");
		Optional<Menu> OptinalMenu = menuFindService.menuFindById(id);
		if (OptinalMenu.isPresent()) {
			Menu menu = OptinalMenu.get();
			return ResponseEntity.ok(menu);
		}
		else
			return ResponseEntity.notFound().build();
	}
}