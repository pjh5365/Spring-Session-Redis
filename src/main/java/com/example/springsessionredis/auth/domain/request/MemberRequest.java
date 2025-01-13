package com.example.springsessionredis.auth.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequest {

	private String username;
	private String password;
}
