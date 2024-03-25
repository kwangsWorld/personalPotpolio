package com.kh.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class KhInterceptor implements HandlerInterceptor{

	// 간섭 시점 : 요청 처리 전
	// 리턴 값 : 핸들러까지 넘길지 말지 결정
	// 핸들러: 컨트롤러 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("간섭시점1 (요청 처리 전...)");
		return true;
	}

	// 간섭 시점 : 요청 처리 직후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("간섭시점2 (요청 처리 전...)");
	}

	// 간섭 시점 : 사용자에게 출력되기 직전
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("간섭시점3 (사용자에게 출력하기 전...)");
	}

	
}
