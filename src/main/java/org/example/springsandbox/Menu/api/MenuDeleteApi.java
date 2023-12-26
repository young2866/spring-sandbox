package org.example.springsandbox.Menu.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.application.MenuDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuDeleteApi {
	private final MenuDeleteService menuDeleteService;

	@DeleteMapping("/venue/menu/{id}")
	public ResponseEntity<Void> menuDelete(@PathVariable Long id) {
		menuDeleteService.menuDelete(id);
		return ResponseEntity.ok().build();
	}

}