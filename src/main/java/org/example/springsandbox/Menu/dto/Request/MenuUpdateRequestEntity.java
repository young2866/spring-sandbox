package org.example.springsandbox.Menu.dto.Request;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Menu.domain.Menu;

@Getter
@NoArgsConstructor
public class MenuUpdateRequestEntity {
	private String name;
	private Integer price;

	@Builder
	public MenuUpdateRequestEntity(String name, Integer price) {
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