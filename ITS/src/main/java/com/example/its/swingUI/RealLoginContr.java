package com.example.its.swingUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.its.logic.UserService;

import lombok.RequiredArgsConstructor;

@Controller
public class RealLoginContr extends LoginController {
    @Autowired
    UserService userService;

    public RealLoginContr(BaseController base) {
        super(base);
    }

    public RealLoginContr(){
        super(new TestBaseCon());
    }

    @Override
    public boolean sendLogin(String id, String password) {
        return userService.login(id, password);
    }

    @Override
    public void openMainScene() {
        new RealMainContr(base);
    }
}
