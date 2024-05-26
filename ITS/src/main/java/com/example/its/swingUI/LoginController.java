package com.example.its.swingUI;

public abstract class LoginController {
    protected BaseController base;
    protected LoginFrame frame;

    public abstract boolean sendLogin(String id, String password);

    LoginController(){
        
    }

    public LoginController(BaseController base){
        this.base = base;
        frame = new LoginFrame(this);
    }

    public abstract void openMainScene();

    public void run(){
        this.frame.setVisible(true);
    }
}
