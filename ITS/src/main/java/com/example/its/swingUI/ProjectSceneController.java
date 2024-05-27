package com.example.its.swingUI;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;

public class ProjectSceneController {
    private BaseController baseController;
    protected IssueSceneController issueSceneController;

    protected ProjectScenePanel panel;

    protected ProjectID projectId;

    public ProjectSceneController(BaseController baseController){
        this.baseController = baseController;

        this.panel = new ProjectScenePanel(this);
    }

    public Issue[] getIssueList(){
        return baseController.getIssueList();
    }

    public void setProjectPanel(Project project){
        setBasePanel();
        this.projectId = project.getProjectID();
        panel.setProjInfo(project);
    }

    public void setBasePanel(){
        this.baseController.setBasePanel(panel);
    }
}
