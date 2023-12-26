package org.example.springsandbox.User.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springsandbox.domain.entity.BaseTimeEntity;
import org.example.springsandbox.Review.domain.Review;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "users")
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "nickname", nullable = false, unique = true)
	private String nickname;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;

	@JsonManagedReference
	@Builder.Default
	@OneToMany(mappedBy = "user")
	private List<Review> reviewList = new ArrayList<>();

	public void update(String password, String nickname) {
		this.password = password;
		this.nickname = nickname;
	}
}