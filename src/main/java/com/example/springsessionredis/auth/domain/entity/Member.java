package com.example.springsessionredis.auth.domain.entity;

import com.example.springsessionredis.auth.domain.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;

	@Enumerated(value = EnumType.STRING)
	private UserRole userRole;

	public Member(String username, String password) {
		this.username = username;
		this.password = password;
		this.userRole = UserRole.ROLE_USER;
	}
}
