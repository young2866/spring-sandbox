package org.example.springsandbox.Menu.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;
import org.example.springsandbox.Menu.dto.Request.MenuUpdateRequestEntity;
import org.example.springsandbox.Menu.repository.MenuRepository;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.dto.request.VenueUpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MenuUpdateService {
	private final MenuRepository menuRepository;

	public Long update(Long id, MenuUpdateRequestEntity menuUpdateRequestEntity) {

		Optional<Menu> menu = menuRepository.findById(id);

		if(menu.isPresent()) {
			Menu updateMenu = menu.get();
			updateMenu.update(menuUpdateRequestEntity.getName()
				,menuUpdateRequestEntity.getPrice());

			return menuRepository.save(updateMenu).getId();
		}else {
			// ID에 해당하는 사용자를 찾지 못한 경우 404 응답
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu not found");
		}
	}

}