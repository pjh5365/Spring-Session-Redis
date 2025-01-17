package com.example.springsessionredis.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.springsessionredis.auth.domain.filter.CustomLoginFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws
			Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/join").permitAll()
						.requestMatchers("/api/login").permitAll()
						.requestMatchers("/api/any").permitAll()
						.anyRequest().authenticated()
				);

		http
				.addFilterBefore(customLoginFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class)
				.formLogin(AbstractHttpConfigurer::disable)
				.cors(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable);

		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws
			Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public CustomLoginFilter customLoginFilter(AuthenticationManager authenticationManager) {
		return new CustomLoginFilter(authenticationManager);
	}
}
