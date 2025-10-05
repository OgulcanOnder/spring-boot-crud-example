package com.ogulcanonder.crud_example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmailNotUniqueException.class})
    public ResponseEntity<Object> handleEmailNotUniqueException(EmailNotUniqueException emailNotUniqueException) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(emailNotUniqueException.getMessage());

    }

    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(employeeNotFoundException.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object>handleRuntimeException(RuntimeException runtimeException){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(runtimeException.getMessage());
    }

}
