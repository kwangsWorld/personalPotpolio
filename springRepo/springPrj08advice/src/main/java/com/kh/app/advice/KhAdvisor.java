package com.kh.app.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class KhAdvisor {
	
	@ExceptionHandler(ArithmeticException.class)
	public void m01() {
		log.info("수학 어쩌고 에러 발생 ~~~ !!!");
	}
	
	@ExceptionHandler(NullPointerException.class)
	public void m02(HttpServletRequest req, HttpServletResponse resp) {
		log.info("널포인터 익셉션 발생 ~~~ !!!");
	}

}