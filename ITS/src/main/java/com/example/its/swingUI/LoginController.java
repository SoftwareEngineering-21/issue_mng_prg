package com.example.its.swingUI;

import com.example.its.logic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public abstract class LoginController {

    protected UserService userService;
    protected BaseController base;
    protected LoginFrame frame;

    public abstract boolean sendLogin(String id, String password);

    @Autowired
    public LoginController(UserService userService, BaseController base){
        this.userService = userService;
        this.base = base;
        frame = new LoginFrame(this);
    }

    public abstract void openMainScene();

    public void run(){
        this.frame.setVisible(true);
    }
}
