package org.example.springsandbox.Venue.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Venue.domain.Venue;

@Getter
@NoArgsConstructor
public class VenueUpdateRequestDto {

	private String name;
	private String phoneNumber;

	@Builder
	public VenueUpdateRequestDto(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Venue toEntity() {
		return Venue.builder()
			.name(name)
			.phoneNumber(phoneNumber)
			.build();
	}
}