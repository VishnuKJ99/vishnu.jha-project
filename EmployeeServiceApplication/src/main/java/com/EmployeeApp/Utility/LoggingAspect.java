package com.EmployeeApp.Utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.EmployeeApp.Exception.EmployeeException;

@Component
@Aspect
public class LoggingAspect
{

    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut="execution(* com.EmployeeApp.Service.EmployeeServiceImpl.*(..))",throwing = "exception")
    public void logServiceException(EmployeeException exception)
    {
    	LOGGER.error(exception.getMessage(),exception);
    	
    }

}
