package com.example.its.swingUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.its.logic.UserService;

import lombok.RequiredArgsConstructor;

@Component
public class RealLoginContr extends LoginController {

    RealMainContr mainController;

    @Autowired
    public RealLoginContr(RealMainContr mainController, UserService userService, BaseController base) {

        super(userService, base);
        this.mainController = mainController;
    }

//    public RealLoginContr(){
//        super(new TestBaseCon());
//    }

    @Override
    public boolean sendLogin(String id, String password) {
        System.out.println(id + " try login");
        return userService.login(id, password);
    }

    @Override
    public void openMainScene() {
        mainController.run();
    }
}
