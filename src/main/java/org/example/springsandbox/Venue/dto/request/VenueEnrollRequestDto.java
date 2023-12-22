package org.example.springsandbox.Venue.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Venue.domain.Venue;

@Getter
@NoArgsConstructor
public class VenueEnrollRequestDto {

	private String name;
	private String address;
	private String phoneNumber;
	private String category;

	@Builder
	public VenueEnrollRequestDto(String name, String address, String phoneNumber, String category) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.category = category;
	}

	public Venue toEntity() {
		return Venue.builder()
			.name(name)
			.address(address)
			.phoneNumber(phoneNumber)
			.category(category)
			.build();
	}
}