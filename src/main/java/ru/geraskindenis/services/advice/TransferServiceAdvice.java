package ru.geraskindenis.services.advice;

import java.math.BigDecimal;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import ru.geraskindenis.services.exceptions.TransferServiceException;

@Aspect
@Service
public class TransferServiceAdvice {

	@Around("execution(* ru.geraskindenis.services.TransferService.transferMoney(..))")
	public void transferMoney(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object[] args = joinPoint.getArgs();
		BigDecimal amount = (BigDecimal) args[2];

		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new TransferServiceException(
					"Transfer amount = " + amount + ",  can't be less than or equal to zero.");
		}

		joinPoint.proceed(args);
	}
}
