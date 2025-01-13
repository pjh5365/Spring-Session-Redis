package com.example.springsessionredis.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CommonRestAdvice {

	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		log.info("[예외발생]: {}", e.getMessage());

		return e.getMessage();
	}
}
