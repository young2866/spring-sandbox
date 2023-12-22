package org.example.springsandbox.Menu.application;

import lombok.RequiredArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;
import org.example.springsandbox.Menu.dto.Request.MenuRegisterRequestDto;
import org.example.springsandbox.Menu.repository.MenuRepository;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MenuRegisterService {
	private final MenuRepository menuRepository;
	private final VenueRepository venueRepository;

	public Long register(MenuRegisterRequestDto menuRegisterRequestDto) {
		Venue venue = venueRepository.findById(menuRegisterRequestDto.getVenue_id())
			.orElseThrow(() -> new IllegalArgumentException("해당 장소가 존재하지 않습니다."));
		Menu menu = menuRegisterRequestDto.toEntity(menuRegisterRequestDto.getName(),
			menuRegisterRequestDto.getPrice(),
			venue);
		return menuRepository.save(menu).getId();
	}
}