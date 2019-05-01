package com.synchrony.assessment.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AssessmentException {

	@ExceptionHandler(value = Exception.class)
	public void handleException(Throwable e) {
		
	}
}
