package com.example.its.swingUI;

public class TestLoginController implements LoginController {
    @Override
    public boolean sendLogin(String id, String password) {
        if(id.isEmpty() || password.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public void openMainScene() {
        BaseController base = new TestBaseCon();
        new TestMainController(base);
    }
}
