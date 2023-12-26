package org.example.springsandbox.Menu.dto.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;

@Getter
@NoArgsConstructor
public class MenuUpdateRequestDto {
	private String name;
	private Integer price;

	@Builder
	public MenuUpdateRequestDto(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	public Menu toEntity(String name, Integer price) {
		return Menu.builder()
			.name(name)
			.price(price)
			.build();
	}

}