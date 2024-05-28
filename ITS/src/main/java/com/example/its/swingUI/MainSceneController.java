package com.example.its.swingUI;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;


//MainScene을 위한 기능이 담긴 interface입니다. 추후에 다른 이름으로 수정될 수 있습니다.
public class MainSceneController {
    private BaseController baseController;

    protected MakeProjectFrameController makeProjectController;
    protected ProjectSceneController projSceneController;
    
    protected MainScenePanel panel;

    protected ProjectID[] adminProjectIdList;
    protected ProjectID[] projectIdList;


    protected MainSceneController(BaseController baseController){
        this.baseController = baseController;

        this.makeProjectController = new MakeProjectFrameController(this.baseController, this);
        this.projSceneController = new ProjectSceneController(this.baseController);

        this.panel = new MainScenePanel(this);
    }

    public Project[] getAdminProjectList(){
        Project[] list = this.baseController.getAdminProjectList();
        this.adminProjectIdList = new ProjectID[list.length];
        for (int i = 0; i < list.length; i++) {
            this.adminProjectIdList[i] = list[i].getProjectID();
        }

        return list;
    }

    public Project[] getProjectList(){
        Project[] list = this.baseController.getProjectList();
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
        if(adminProjectIdList.length > index){
            Project[] adminList = this.baseController.getAdminProjectList();

            if(adminList == null){
                System.out.println("Error!");
                return;
            }

            for (Project project : adminList) {
                if(project.getProjectID().getID() == this.adminProjectIdList[index].getID()){
                    this.makeProjectController.dispose();
                    this.projSceneController.setProjectPanel(project);
                    return;
                }
            }
        }
        else{
            Project[] list = this.baseController.getProjectList();

            if(list == null){
                System.out.println("Error!");
                return;
            }

            for(Project project : list) {
                if(project.getProjectID().getID() == this.projectIdList[index - adminProjectIdList.length].getID()){
                    this.makeProjectController.dispose();
                    this.projSceneController.setProjectPanel(project);
                    return;
                }
            }
        }

        System.out.println("There is no project in DB");
    }

    public void setBasePanel(){
        panel.makeProjectList();
        this.baseController.setBasePanel(panel);
    }

    public void makeProjectList() {
        panel.makeProjectList();
    }
}