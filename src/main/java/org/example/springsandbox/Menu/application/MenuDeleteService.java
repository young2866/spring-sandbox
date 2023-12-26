package org.example.springsandbox.Menu.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuDeleteService {
	private final MenuRepository menuRepository;

	public void menuDelete(Long id) {
		menuRepository.deleteById(id);
	}

}