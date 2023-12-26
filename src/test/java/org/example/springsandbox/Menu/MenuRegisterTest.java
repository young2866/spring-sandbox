package org.example.springsandbox.Menu;

import jakarta.persistence.EntityManager;
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

@DataJpaTest
@DisplayName("메뉴 등록 테스트")
public class MenuRegisterTest {

	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private VenueRepository venueRepository;

	@Test
	@Transactional
	public void 정상_등록() throws Exception {
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
	    //when
		menuRepository.save(menu);
	    //then
		Menu registeredMenu = menuRepository.findById(menu.getId()).orElse(null);
		Assertions.assertThat(registeredMenu).isEqualTo(menu);
	}

}