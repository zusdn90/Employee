package com.hybrid.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TransactionAspect {

	static Log log = LogFactory.getLog(TransactionAspect.class);
	
	@Around("execution(public * com.hybrid.service.*Service.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		// before

		log.info("### before");
		Object rtn = null;
		try {
			rtn = pjp.proceed();
			// afterReturnning
			log.info("### afterReturnning");
		} catch (Throwable t) {
			// afterThrowing
			log.info("### afterThrowing");
			throw t;
		}finally{
		// after
			log.info("### after");
		}
		return rtn;
	}
}
