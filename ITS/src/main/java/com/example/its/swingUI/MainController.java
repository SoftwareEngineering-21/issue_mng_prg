package com.example.its.swingUI;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;


//MainScene을 위한 기능이 담긴 interface입니다. 추후에 다른 이름으로 수정될 수 있습니다.
public class MainController {
    private ServiceLayer serviceLayer;

    protected MakeProjectController makeProjectController;
    protected ProjectSceneController projSceneController;
    
    protected MainScenePanel panel;

    protected ProjectID[] projectIdList;


    protected MainController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;

        this.makeProjectController = new MakeProjectController(this.serviceLayer);
        this.projSceneController = new ProjectSceneController(this.serviceLayer);

        this.panel = new MainScenePanel(this);
    }

    public Project[] getProjectList(){
        Project[] list = this.serviceLayer.getProjectList();
        this.projectIdList = new ProjectID[list.length];
        for (int i = 0; i < list.length; i++) {
            this.projectIdList[i] = list[i].getProjectID();
        }

        return list;
    }

    public void runMakeProject(){
        this.makeProjectController.run();
    }
    
    public void runProjectScene(int index){
        Project[] list = this.serviceLayer.getProjectList();

        if(list == null){
            System.out.println("Error!");
            return;
        }

        for (Project project : list) {
            if(project.getProjectID().getID() == this.projectIdList[index].getID()){
                this.makeProjectController.dispose();
                this.projSceneController.setProjectPanel(project);
                return;
            }
        }

        System.out.println("There is no project in DB");
    }

    public void setBasePanel(){
        panel.makeProjectList();
        this.serviceLayer.setBasePanel(panel);
    }
}