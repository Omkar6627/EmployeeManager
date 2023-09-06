package com.EmployeeManager.HR.Stats.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HRNotFoundException extends RuntimeException {
    public HRNotFoundException(String message) {
        super(message);
    }
}
