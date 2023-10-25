package com.joaovictorjpg.github.jloja.model.services.exceptionServices;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource not found. Id " + id);
    }
}
