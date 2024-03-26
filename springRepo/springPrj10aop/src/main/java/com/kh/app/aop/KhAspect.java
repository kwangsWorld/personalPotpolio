package com.kh.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect
public class KhAspect {
	
//	@Before("target(com.kh.app.board.dao.BoardDao)")
//	@After("target(com.kh.app.board.dao.BoardDao)")
//	@AfterReturning("target(com.kh.app.board.dao.BoardDao)") //리턴값이 올바르게 왔을 때 동작하게 함
//	@AfterThrowing("target(com.kh.app.board.dao.BoardDao)") //예외가 발생했을 때 동작하게 함
//	@Around("excution(표현식)") // 실행되기 이전과 이후 둘다 동작함
	public Object m01(ProceedingJoinPoint jp) throws Throwable { //around는 메소드 형태 고정되어 있음
		System.out.println("aspect 메소드 호출됨");
		Object x = jp.proceed();
		System.out.println("aspect에서 받은 타겟메소드의 리턴값 : " + x);
		System.out.println("aspect 메소드 호출됨 2222");
		return x;
	}

}
