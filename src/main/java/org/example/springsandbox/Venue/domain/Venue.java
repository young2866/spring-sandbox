package org.example.springsandbox.Venue.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.domain.entity.BaseTimeEntity;
import org.example.springsandbox.domain.entity.Menu;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Venue extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(name = "category", nullable = false)
	private String category;

	@Builder.Default
	@OneToMany(mappedBy = "venue")
	private List<Menu> menuList = new ArrayList<>();

	public void update(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

}