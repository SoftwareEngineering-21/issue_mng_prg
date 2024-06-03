package com.example.its.swingUI.Project.Controller;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.Project;
import com.example.its.swingUI.BaseController;
import com.example.its.swingUI.Issue.Controller.IssueSceneController;
import com.example.its.swingUI.Issue.Controller.MakeIssueController;
import com.example.its.swingUI.Project.ProjectScenePanel;

public class ProjectSceneController {
    private BaseController baseController;

    protected MakeIssueController makeIssueController;
    protected IssueSceneController issueSceneController;

    protected ProjectScenePanel panel;

    protected IssueID issueIDs[];

    public ProjectSceneController(BaseController baseController){
        this.baseController = baseController;

        this.issueSceneController = new IssueSceneController(this.baseController);
        this.makeIssueController = new MakeIssueController(this.baseController, this);
        this.panel = new ProjectScenePanel(this);
    }

    public Issue[] getIssueList(){
        Issue[] issues = baseController.getIssueList();
        if(issues == null){
            return null;
        }

        issueIDs = new IssueID[issues.length];
        for(int i = 0; i < issues.length; i++){
            issueIDs[i] = issues[i].getID();
        }

        return issues;
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
        panel.makeIssueList();
        baseController.setBasePanel(panel);
    }

    public void runMakeIssue(){
        makeIssueController.run();
    }

    public void makeIssueList(){
        this.panel.makeIssueList();
    }

    public boolean runIssueScene(int index) {
        if(issueIDs == null || index >= issueIDs.length || index < 0) {
            return false;
        }

        Issue issue = this.baseController.openIssue(issueIDs[index]);
        if(issue == null) {
            return false;
        }
        this.makeIssueController.dispose();
        this.issueSceneController.setBasePanel(issue);
        return true;
    }
}
