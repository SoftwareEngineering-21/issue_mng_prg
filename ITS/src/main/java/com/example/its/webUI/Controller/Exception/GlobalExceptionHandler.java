package com.example.its.webUI.Controller.Exception;

import com.example.its.logic.Exception.LoginFailureException;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.logic.Exception.LoginUnrequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LoginRequiredException.class)
    public String loginException(LoginRequiredException ex) {
        System.out.println("LoginException: Login session expired");
        return "redirect:/";
    }

    @ExceptionHandler(LoginUnrequiredException.class)
    public String loginUnrequiredException(LoginUnrequiredException ex) {
        System.out.println("LoginUnrequiredException: Login not required.");
        return "redirect:/";
    }

    @ExceptionHandler(LoginFailureException.class)
    public void loginFailureException(LoginFailureException ex){
        System.out.println("Login Failure.");
    }
}
