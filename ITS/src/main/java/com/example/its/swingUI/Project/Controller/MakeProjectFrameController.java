package com.example.its.swingUI.Project.Controller;

import com.example.its.swingUI.BaseController;
import com.example.its.swingUI.Project.MakeProjectFrame;

public class MakeProjectFrameController {
    BaseController baseController;
    MainSceneController controller;

    MakeProjectFrame frame;

    MakeProjectFrameController(BaseController baseController, MainSceneController controller){
        this.baseController = baseController;
        this.controller = controller;

        frame = new MakeProjectFrame(this);
    }

    public void makeNewProject(String title, String desc){
        this.baseController.makeProject(title, desc);
        this.controller.makeProjectList();
    }

    public void run(){
        frame.setVisible(true);
    }

    public void dispose(){
        frame.dispose();
    }
}
