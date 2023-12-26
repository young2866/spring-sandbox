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
@DisplayName("장소 업데이트 테스트")
public class VenueUpdateTest {

	@Autowired
	private VenueRepository venueRepository;

	@Test
	@Transactional
	public void 정상_업데이트() throws Exception {
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

		venueRepository.save(venue);

	    //when
		venue.update("백엔드4기", "01000000000");
		venueRepository.save(venue);
		Venue updatedVenue = venueRepository.findById(venue.getId()).orElse(null);
	    //then
		Assertions.assertThat(updatedVenue.getName()).isEqualTo("백엔드4기");
		Assertions.assertThat(updatedVenue.getPhoneNumber()).isEqualTo("01000000000");
	}

	@Test
	@Transactional
	public void 이름중복_업데이트() throws Exception {
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
			.name("백엔드4기")
			.address("관악구")
			.phoneNumber("01012345679")
			.category("학원")
			.build();

		venueRepository.save(venue);
		venueRepository.save(secondVenue);
	    //when
		venue.update("백엔드4기","01000000000");
		venueRepository.save(venue);
	    //then
		Assertions.assertThatThrownBy(() -> venueRepository.flush()).isInstanceOf(
			DataIntegrityViolationException.class);
	}



}