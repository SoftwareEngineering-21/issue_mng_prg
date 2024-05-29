package com.example.its.webUI.Controller.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LoginException.class)
    public String loginException(LoginException ex) {
        System.out.println("LoginException: Login session expired");
        return "redirect:/";
    }

    @ExceptionHandler(LoginUnrequiredException.class)
    public String loginUnrequiredException(LoginUnrequiredException ex) {
        System.out.println("LoginUnrequiredException: Login not required.");
        return "redirect:/";
    }
}
