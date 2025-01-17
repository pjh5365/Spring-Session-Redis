package com.example.springsessionredis.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 모든 경로에 대해 CORS 허용
		registry.addMapping("/**")
				.allowedOrigins("http://10.0.0.6", "http://223.130.137.86")  // 허용할 Origin을 나열
				.allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드
				.allowedHeaders("*")  // 허용할 헤더
				.allowCredentials(true)  // 쿠키 전송 허용
				.maxAge(3600);  // CORS 응답 캐시 시간 (1시간)
	}
}
