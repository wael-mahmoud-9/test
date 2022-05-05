package consommi.tounsi.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class LoggingAspect {
	
	@Before("execution(* consommi.tounsi.service.*.*(..))")
	public void LogMethodEntry(JoinPoint joinpoint) {
		String name = joinpoint.getSignature().getName();
		log.info("In Method: "+ name + ":");
	}

}
