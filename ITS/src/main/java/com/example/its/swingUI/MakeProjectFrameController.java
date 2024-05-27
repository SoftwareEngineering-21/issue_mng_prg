package com.example.its.swingUI;

public class MakeProjectFrameController {
    BaseController serviceLayer;

    MakeProjectFrame frame;

    MakeProjectFrameController(BaseController serviceLayer){
        this.serviceLayer = serviceLayer;

        frame = new MakeProjectFrame(this);
    }

    public void makeNewProject(String title, String desc){
        this.serviceLayer.makeProject(title, desc);
    }

    public void run(){
        frame.setVisible(true);
    }

    public void dispose(){
        frame.dispose();
    }
}
