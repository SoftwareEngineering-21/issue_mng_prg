package com.example.its.swingUI;

import com.example.its.dataClass.Project;


//MainScene을 위한 기능이 담긴 interface입니다. 추후에 다른 이름으로 수정될 수 있습니다.
public class MainController {
    protected MakeProjectController makeProjectController;
    protected ProjectSceneController projSceneController;
    
    protected MainScenePanel panel;

    private ServiceLayer serviceLayer;

    protected MainController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;

        this.panel = new MainScenePanel(this);
    }

    public Project[] getProjectList(){
        return this.serviceLayer.getProjectList();
    }

    public void runMakeProject(){

    }
    
    public void runProjectScene(int index){

    }

    public void setBasePanel(){
        panel.makeProjectList();
        this.serviceLayer.setBasePanel(panel);
    }
}