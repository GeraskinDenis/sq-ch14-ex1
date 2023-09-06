package ru.geraskindenis.controllers.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ru.geraskindenis.services.exceptions.TransferServiceException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> exceptionTransferServiceHandler(RuntimeException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(TransferServiceException.class)
	public ResponseEntity<String> exceptionTransferServiceHandler(TransferServiceException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
//
//	@ExceptionHandler(NotEnoughMoneyException.class)
//	public ResponseEntity<NotEnoughMoneyException> notEnoughMoneyExceptionHandler(NotEnoughMoneyException e) {
//		return ResponseEntity.badRequest().body(e);
//	}

}
