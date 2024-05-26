package com.example.its.swingUI;

public class LoginController {
    protected ServiceLayer serviceLayer;
    protected MainController mainController;

    protected LoginFrame frame;


    public LoginController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;

        this.mainController = new MainController(this.serviceLayer);
        this.frame = new LoginFrame(this);
    }

    public boolean sendLogin(String id, String password){
        return this.serviceLayer.login(id, password);
    }

    public void run(){
        this.frame.setVisible(true);
    }

    public void runMainScene(){
        this.mainController.setBasePanel();
        this.serviceLayer.runBase();
    }
}
