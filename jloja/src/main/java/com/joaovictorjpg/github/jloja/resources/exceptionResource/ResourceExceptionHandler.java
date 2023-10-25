package com.joaovictorjpg.github.jloja.resources.exceptionResource;

import com.joaovictorjpg.github.jloja.model.entities.exceptions.StandardError;
import com.joaovictorjpg.github.jloja.model.services.exceptionServices.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
        Integer status = HttpStatus.NOT_FOUND.value();
        String error = "Resource not found";
        StandardError erro = new StandardError(Instant.now(),status, error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

}
