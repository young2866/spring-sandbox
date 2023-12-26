package org.example.springsandbox.Menu;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.example.springsandbox.Menu.domain.Menu;
import org.example.springsandbox.Menu.repository.MenuRepository;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("메뉴 검색 테스트")
public class MenuFindTest {

	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private VenueRepository venueRepository;

	@Test
	@Transactional
	public void 메뉴검색_Id() throws Exception {
		//given
		Venue venue = Venue.builder()
			.name("백엔드3기")
			.address("동작구")
			.phoneNumber("010111111111")
			.category("학원")
			.build();
		venueRepository.save(venue);

		Menu menu = Menu.builder()
			.name("김영광")
			.price(1000)
			.venue(venue)
			.build();

		menuRepository.save(menu);
		//when
		Menu findedMenu = menuRepository.findById(menu.getId()).orElse(null);
		//then

		Assertions.assertThat(findedMenu.getId()).isEqualTo(menu.getId());
	}

}