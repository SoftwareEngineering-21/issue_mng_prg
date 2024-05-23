package com.example.its.swingUI;

public abstract class MakeProjectController {
    MakeProjectFrame frame;
    MainController controller;

    MakeProjectController(MainController controller){
        this.controller = controller;
        frame = new MakeProjectFrame(this);
    }

    public abstract void makeNewProject(String title, String Desc);
    public abstract void setVisible(boolean isVisible);
}
