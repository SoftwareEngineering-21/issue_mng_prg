package com.example.its.swingUI;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;

public class ProjectSceneController {
    private ServiceLayer serviceLayer;
    protected IssueController issueController;

    protected ProjectScenePanel panel;

    public ProjectSceneController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;

        this.panel = new ProjectScenePanel(this);
    }

    public Issue[] getIssueList(){
        return serviceLayer.getIssueList();
    }

    public void setProjectPanel(Project project){
        setBasePanel();
        panel.setProjInfo(project);
    }

    public void setBasePanel(){
        this.serviceLayer.setBasePanel(panel);
    }
}
