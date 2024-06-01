package com.example.its.swingUI.Project.Controller;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.swingUI.BaseController;
import com.example.its.swingUI.Project.MainScenePanel;


//MainScene을 위한 기능이 담긴 interface입니다. 추후에 다른 이름으로 수정될 수 있습니다.
public class MainSceneController {
    private final BaseController baseController;

    protected MakeProjectFrameController makeProjectController;
    protected ProjectSceneController projSceneController;
    
    protected MainScenePanel panel;

    protected ProjectID[] adminProjectIdList;
    protected ProjectID[] projectIdList;


    public MainSceneController(BaseController baseController){
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
    
    public boolean runProjectScene(int index){
        Project target = null;

        if(adminProjectIdList.length > index){
            target = this.baseController.openProject(adminProjectIdList[index]);
        }
        else{
            target = this.baseController.openProject(projectIdList[index - adminProjectIdList.length]);
        }

        if(target != null){
            this.makeProjectController.dispose();
            this.projSceneController.setProjectPanel(target);
            return true;
        }
        else{
            return false;
        }
    }

    public void setBasePanel(){
        panel.makeProjectList();
        this.baseController.setBasePanel(panel);
    }

    public void makeProjectList() {
        panel.makeProjectList();
    }
}