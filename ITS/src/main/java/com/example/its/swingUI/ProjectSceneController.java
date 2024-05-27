package com.example.its.swingUI;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;

public class ProjectSceneController {
    private ServiceLayer serviceLayer;
    protected IssueController issueController;

    protected ProjectScenePanel panel;

    protected ProjectID projectId;

    public ProjectSceneController(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;

        this.panel = new ProjectScenePanel(this);
    }

    public Issue[] getIssueList(){
        return serviceLayer.getIssueList(projectId);
    }

    public void setProjectPanel(Project project){
        setBasePanel();
        this.projectId = project.getProjectID();
        panel.setProjInfo(project);
    }

    public void setBasePanel(){
        this.serviceLayer.setBasePanel(panel);
    }
}
