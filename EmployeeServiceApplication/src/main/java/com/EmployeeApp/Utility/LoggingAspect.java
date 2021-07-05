package com.EmployeeApp.Utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.EmployeeApp.Exception.EmployeeException;

public class LoggingAspect
{

    private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    public void logServiceException(EmployeeException exception)
    {
	
    }

}
