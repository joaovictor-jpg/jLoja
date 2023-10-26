package com.joaovictorjpg.github.jloja.model.services.exceptionServices;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg) {
        super(msg);
    }
}
