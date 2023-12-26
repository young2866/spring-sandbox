package org.example.springsandbox.Venue;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.Venue.repository.VenueRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("장소 검색 테스트")
public class VenueFindTest {

	@Autowired
	private VenueRepository venueRepository;

	@Test
	@Transactional
	public void 정상_검색() throws Exception {
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
		Venue findVenue = venueRepository.findById(venue.getId()).orElse(null);

	    //then
		Assertions.assertThat(findVenue).isEqualTo(venue);
	}

	@Test
	@Transactional
	public void Venue_검색_Name() throws Exception {
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
		Venue findVenue = venueRepository.findByName(venue.getName()).orElse(null);
	    //then
		Assertions.assertThat(findVenue).isEqualTo(venue);
	}


}