package com.example.springsessionredis.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {

	@GetMapping("/test")
	public String test() {
		log.info("인증한 사용자의 접근 요청");
		return "인증 성공";
	}

	@GetMapping("/any")
	public String any() {
		log.info("누구나 접근 가능한 접근 요청");
		return "누구나 접근 가능";
	}
}
