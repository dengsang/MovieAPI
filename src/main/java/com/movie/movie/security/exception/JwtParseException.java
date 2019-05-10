package com.movie.movie.security.exception;


import org.springframework.security.core.AuthenticationException;

public class JwtParserException extends AuthenticationException {

    
    public JwtParseException(Exception e) {
        super(e.getMessage(), e);
    }
}
