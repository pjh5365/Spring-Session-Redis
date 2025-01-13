package com.example.springsessionredis.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsessionredis.auth.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	boolean existsByUsername(String username);

	Optional<Member> findByUsername(String username);
}
