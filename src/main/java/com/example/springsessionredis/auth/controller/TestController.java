package com.example.springsessionredis.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "인증 성공";
	}

	@GetMapping("/any")
	public String any() {
		return "누구나 접근 가능";
	}
}
