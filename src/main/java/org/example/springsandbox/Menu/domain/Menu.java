package org.example.springsandbox.Menu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.Venue.domain.Venue;
import org.example.springsandbox.domain.entity.BaseTimeEntity;
import org.example.springsandbox.Review.domain.Review;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Menu extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "price", nullable = false)
	private Integer price;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "venue_id", nullable = false)
	private Venue venue;

	@JsonManagedReference
	@Builder.Default
	@OneToMany(mappedBy = "menu")
	private List<Review> reviewList = new ArrayList<>();

	public void update(String name, Integer price) {
		this.name = name;
		this.price = price;
	}


}