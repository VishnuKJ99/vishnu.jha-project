package com.EmployeeApp.Utility;

import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.EmployeeApp.Exception.EmployeeException;
import com.EmployeeApp.Utility.ErrorInfo;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	//private static final Log LOGGER=LogFactory.getLog(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler2(EmployeeException exception) {
		
		//LOGGER.error(exception.getMessage(), exception);
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception){
	
		//LOGGER.error(exception.getMessage(), exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setErrorMessage(exception.getMessage());
		return new ResponseEntity<>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	@ExceptionHandler({MethodArgumentNotValidException.class , ConstraintViolationException.class})
	public ResponseEntity<ErrorInfo> validatorExceptionHandler(Exception exception){
		
		 //LOGGER.error(exception.getMessage(), exception);
		String errorMsg;
		if (exception instanceof MethodArgumentNotValidException)
		{
		    MethodArgumentNotValidException manvException = (MethodArgumentNotValidException) exception;
		    errorMsg = manvException.getBindingResult()
					    .getAllErrors()
					    .stream()
					    .map(ObjectError::getDefaultMessage)
					    .collect(Collectors.joining(", "));

		}
		else
		{
		    ConstraintViolationException cvException = (ConstraintViolationException) exception;
		    errorMsg = cvException.getConstraintViolations()
					  .stream()
					  .map(ConstraintViolation::getMessage)
					  .collect(Collectors.joining(", "));

		}
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(errorMsg);
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	    }

	}


