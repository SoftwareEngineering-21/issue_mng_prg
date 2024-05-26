package com.example.its.swingUI;

public class MakeProjectController {
    ServiceLayer serviceLayer;

    MakeProjectFrame frame;

    MakeProjectController(ServiceLayer serviceLayer){
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
