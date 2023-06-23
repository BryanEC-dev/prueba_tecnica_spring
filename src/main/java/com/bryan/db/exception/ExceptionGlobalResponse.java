package com.bryan.db.exception;

import com.bryan.db.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class ExceptionGlobalResponse {

    ExceptionResponse response;

    @ExceptionHandler(NotFoundOrderException.class)
    public ResponseEntity<ExceptionResponse> notFoundOrderException(RuntimeException e) {
        response = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), e.getMessage(), 404, "ok");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongTypeParameterException.class)
    public ResponseEntity<ExceptionResponse> wrongTypeParameterException(RuntimeException e) {
        response = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), e.getMessage(), 400, "Error");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException e) {
        response = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), e.getMessage(), 500, "Error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exception(Exception e) {
        response = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), e.getMessage(), 500, "Error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
