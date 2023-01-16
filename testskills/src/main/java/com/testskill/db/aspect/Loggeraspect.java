package com.testskill.db.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.testskill.db.rest.Controller;

@Aspect
@Component
public class Loggeraspect {
	Logger log=LoggerFactory.logger(Controller.class);
@Around("@annotation(com.testskill.db.aspect.Loggerstu)")
public void timecal(ProceedingJoinPoint p) throws Throwable {
	 long starttime= System.currentTimeMillis();
	p.proceed();
	long endtime=System.currentTimeMillis();
	long time=endtime-starttime;
	log.debug(time);
	
	
}

}
