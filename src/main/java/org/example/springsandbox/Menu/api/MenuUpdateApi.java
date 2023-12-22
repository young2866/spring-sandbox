package org.example.springsandbox.Menu.api;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.application.MenuUpdateService;
import org.example.springsandbox.Menu.dto.Request.MenuUpdateRequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuUpdateApi {

	private final MenuUpdateService menuUpdateService;

	@PutMapping("/venue/menu/{id}")
	public ResponseEntity<Long> update(@PathVariable Long id
		, @RequestBody MenuUpdateRequestEntity menuUpdateRequestEntity) {

		Long update = menuUpdateService.update(id, menuUpdateRequestEntity);
		return ResponseEntity.ok(update);
	}
}