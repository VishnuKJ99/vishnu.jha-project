package com.EmployeeTraining.ET.Utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.EmployeeTraining.ET.Exception.EmployeeTrainingException;

@Component
@Aspect
public class LoggingAspect
{

    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut="execution(* com.EmployeeTraining.ET.Service.EmployeeTrainingServiceImpl.*(..))",throwing = "exception")
    public void logServiceException(EmployeeTrainingException exception)
    {
    	LOGGER.error(exception.getMessage(),exception);
    	
    }

}

