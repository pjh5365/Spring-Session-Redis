package com.example.springsessionredis.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsessionredis.auth.domain.entity.Member;
import com.example.springsessionredis.auth.domain.request.MemberRequest;
import com.example.springsessionredis.auth.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * 로그인 메서드
	 *
	 * @param request 로그인 요청을 받아 로그인을 처리한다.
	 *                만약, 존재하는 회원아이디로 요청이 온다면 예외를 던진다.
	 */
	public void join(MemberRequest request) {
		if (memberRepository.existsByUsername(request.getUsername())) {
			throw new IllegalArgumentException("이미 존재하는 회원입니다.");
		}
		Member member = new Member(request.getUsername(), bCryptPasswordEncoder.encode(request.getPassword()));
		memberRepository.save(member);
	}
}
