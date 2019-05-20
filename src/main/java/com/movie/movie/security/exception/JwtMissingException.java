package com.movie.movie.security.exception;


import org.springframework.security.core.AuthenticationException;


public class JwtMissingException extends  AuthenticationException {

    public JwtMissingException() {
        super("JWT Token is missing");
    }
}
