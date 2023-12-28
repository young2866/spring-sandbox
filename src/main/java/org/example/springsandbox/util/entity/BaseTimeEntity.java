package org.example.springsandbox.util.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseTimeEntity {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime created_time;

	@LastModifiedDate
	private LocalDateTime modified_time;

	@PrePersist
	public void prePersist() {
		this.created_time = LocalDateTime.now();
		this.modified_time = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.modified_time = LocalDateTime.now();
	}

}