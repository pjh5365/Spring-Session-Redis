package com.example.springsessionredis.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsessionredis.auth.domain.request.MemberRequest;
import com.example.springsessionredis.auth.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/join")
	public String join(MemberRequest request) {
		System.out.println("회원가입 요청");
		memberService.join(request);

		return "회원가입 성공";
	}
}
