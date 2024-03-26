package com.kh.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class TimerAspect {

	@Around("execution( * com..*.dao.*.*(..) )") //매게변수가 어떤게 오든 신경쓰지 않겠따 (쩜쩜)
	public Object checkTime(ProceedingJoinPoint m) throws Throwable {
		long start = System.nanoTime();
		Object result = m.proceed(); //실제 메소드 호출 , 반환형이 Object임
		long end = System.nanoTime();
		long time = end - start;
		log.info("{}메소드 수행에 걸린 시간 : {}ns", m.getSignature().toLongString(), time);
		return result;
	}
	
}
