package org.example.springsandbox.Venue;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
@DisplayName("장소 등록 테스트")
public class VenueEnrollTest {

	@Autowired
	private VenueRepository venueRepository;

	@Test
	@Transactional
	public void 정상_장소저장() throws Exception {
		//given
		String name = "백엔드3기";
		String address = "동작구";
		String phoneNumber = "01012345678";
		String category = "학원";

		Venue venue = Venue.builder()
			.name(name)
			.address(address)
			.phoneNumber(phoneNumber)
			.category(category)
			.build();

		//when
		venueRepository.save(venue);
		Venue savedVenue = venueRepository.findById(venue.getId()).orElse(null);
		//then
		Assertions.assertThat(savedVenue).isEqualTo(venue);
	}

	@Test
	@Transactional
	public void 중복이름_장소저장() throws Exception {
	    //given
		String name = "백엔드3기";
		String address = "동작구";
		String phoneNumber = "01012345678";
		String category = "학원";

		Venue venue = Venue.builder()
			.name(name)
			.address(address)
			.phoneNumber(phoneNumber)
			.category(category)
			.build();
		Venue secondVenue = Venue.builder()
			.name(name)
			.address("관악구")
			.phoneNumber("01012345679")
			.category("식당")
			.build();
	    //when
		venueRepository.save(venue);

	    //then
		Assertions.assertThatThrownBy(() -> venueRepository.save(secondVenue))
			.isInstanceOf(DataIntegrityViolationException.class);
	}



}