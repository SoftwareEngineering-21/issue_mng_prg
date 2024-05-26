package com.example.its.swingUI;

import com.example.its.dataClass.Project;
import com.example.its.logic.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;


//MainScene을 위한 기능이 담긴 interface입니다. 추후에 다른 이름으로 수정될 수 있습니다.
public abstract class MainController {
    protected ProjectService projectService;
    protected BaseController baseController;
    protected MakeProjectController makeProjCon;
    protected ProjSceneController projCon;
    
    protected MainScenePanel panel;

    public abstract Project[] getProjectList();
    public abstract void openMakeProj();
    public abstract void openProject(int index);

    @Autowired
    protected MainController(ProjectService projectService, BaseController baseController){
        this.projectService = projectService;
        this.baseController = baseController;
        this.panel = new MainScenePanel(this);
    }

    public void setBasePanel(){
        baseController.setPanel(panel);
    }
}