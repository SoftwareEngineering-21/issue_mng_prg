package com.example.its.swingUI;

public class LoginFrameController {
    protected BaseController baseController;
    protected MainSceneController mainSceneController;

    protected LoginFrame frame;


    public LoginFrameController(BaseController baseController){
        this.baseController = baseController;

        this.mainSceneController = new MainSceneController(this.baseController);
        this.frame = new LoginFrame(this);
    }

    public boolean sendLogin(String id, String password){
        return this.baseController.login(id, password);
    }

    public void run(){
        this.frame.setVisible(true);
    }

    public void setVisible(boolean turn){
        this.frame.setVisible(turn);
    }

    public void runMainScene(){
        this.mainSceneController.setBasePanel();
        this.baseController.runBase();
    }
}
