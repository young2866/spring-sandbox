package org.example.springsandbox.Menu.dto.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;
import org.example.springsandbox.Venue.domain.Venue;

@NoArgsConstructor
@Getter
public class MenuRegisterRequestDto {
	private String name;
	private int price;
	private Long venue_id;

	@Builder
	public MenuRegisterRequestDto(String name, int price, Long venue_id) {
		this.name = name;
		this.price = price;
		this.venue_id = venue_id;
	}

	public Menu toEntity(String name, int price, Venue venue) {
		return Menu.builder()
			.name(name)
			.price(price)
			.venue(venue)
			.build();
	}


}