package com.example.springsessionredis.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://10.0.0.6") // Vue 앱이 실행되는 도메인
				.allowedOrigins("http://223.130.137.86") // Vue 앱이 실행되는 도메인
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowCredentials(true);
	}
}
