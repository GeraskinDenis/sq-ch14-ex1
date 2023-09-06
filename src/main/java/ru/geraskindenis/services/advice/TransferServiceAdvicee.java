package ru.geraskindenis.services.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class TransferServiceAdvicee {

	@Around("execution(* ru.geraskindenis.services.TransferService.calculateNewSenderAmount(..))")
	public Object calculateNewSenderAmount(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Aspect: checkNewSenderAmount(ProceedingJoinPoint joinPoint)");
		Object[] args = joinPoint.getArgs();
		Object result = joinPoint.proceed(args);
//		System.out.println("Aspect2: checkNewSenderAmount(ProceedingJoinPoint joinPoint) throws Throwable {");
//		if (newSenderAmount.compareTo(BigDecimal.ZERO) < 0) {
//			throw new TransferServiceException("Amount = " + amount + ",  can't be less than or equal to zero.");
//		}
		return result;

	}
}
