package com.example.springsessionredis.auth.domain.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {
	public CustomLoginFilter(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
		setFilterProcessesUrl("/api/login"); // 로그인 API 엔드포인트 설정
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();

		if (!method.equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UsernamePasswordAuthenticationToken authRequest = UsernamePasswordAuthenticationToken
				.unauthenticated(username, password);

		setDetails(request, authRequest);
		return getAuthenticationManager().authenticate(authRequest);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// 세션에 인증 정보 설정
		SecurityContextHolder.getContext().setAuthentication(authResult);

		// 세션에 인증 정보 저장
		HttpSession session = request.getSession(true);
		session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write("Login successful");
	}

	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
	}
}
