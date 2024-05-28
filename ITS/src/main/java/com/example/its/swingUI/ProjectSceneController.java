package com.example.its.swingUI;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;

public class ProjectSceneController {
    private BaseController baseController;

    protected ProjAuthSceneController projAuthSceneController;

    protected IssueSceneController issueSceneController;

    protected ProjectScenePanel panel;

    public ProjectSceneController(BaseController baseController){
        this.baseController = baseController;

        this.issueSceneController = new IssueSceneController(this.baseController);
        this.projAuthSceneController = new ProjAuthSceneController(this.baseController);
        this.panel = new ProjectScenePanel(this);
    }

    public Issue[] getIssueList(){
        return baseController.getIssueList();
    }

    public void setProjectPanel(Project project){
        setBasePanel();
        //this.projectId = project.getProjectID();
        panel.setProjInfo(project);
    }

    public void setBasePanel(){
        this.baseController.setBasePanel(panel);
    }

    public void run() {
        baseController.setBasePanel(panel);
    }

    public void runProjAuthPanel() {
        projAuthSceneController.run();
    }
}
