package com.swc.weblog.jwt.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author Wilson
 * @Description: TODO
 * @date 2024/9/20 13:04
 */
public class UsernameOrPasswordNullException extends AuthenticationException {
    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}
