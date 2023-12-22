package org.example.springsandbox.Menu.application;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;
import org.example.springsandbox.Menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuFindService {
	private final MenuRepository menuRepository;

	public Optional<Menu> menuFindById(Long id) {
		return menuRepository.findById(id);
	}

}