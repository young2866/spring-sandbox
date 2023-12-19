package org.example.springsandbox.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "nickname", nullable = false)
	private String nickname;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@CreationTimestamp
	@Column(name = "created_time")
	private LocalDateTime created_time = LocalDateTime.now();

	@CreationTimestamp // INSERT 시 자동으로 값을 채워줌
	@Column(name = "modified_time")
	private LocalDateTime modified_time = LocalDateTime.now();


}