package com.database.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Component;

import com.database.demo.service.ServiceValidation;

import ch.qos.logback.classic.Logger;

@Aspect
@Component

public class AddLogger {
	private static org.jboss.logging.Logger log = LoggerFactory.logger(ServiceValidation.class);

	@Before("@annotation(com.database.demo.aspect.LoggerPrd)")
	public void beforeExecute() {
		log.debug("Started----------------------------->");

	}

	@After("@annotation(com.database.demo.aspect.LoggerPrd)")
	public void afterExecute() {
		log.debug("Ended----------------------------->");
	}

	@Around("@annotation(com.database.demo.aspect.LoggerPrd)")
	public Object ExecutionTime(ProceedingJoinPoint jointpoint) throws Throwable {
		Long StartTime=System.currentTimeMillis();
		final Object result=jointpoint.proceed();
		Long Endtime=System.currentTimeMillis();
		log.debug(result);
		log.debug("Executed in "+(Endtime-StartTime)+" ms");
		return result;
    
	}

}
