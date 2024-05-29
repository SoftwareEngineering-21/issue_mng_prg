package com.example.its.swingUI;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.Project;

public class ProjectSceneController {
    private BaseController baseController;

    protected ProjAuthSceneController projAuthSceneController;
    protected MakeIssueController makeIssueController;
    protected IssueSceneController issueSceneController;

    protected ProjectScenePanel panel;

    protected IssueID issueIDs[];

    public ProjectSceneController(BaseController baseController){
        this.baseController = baseController;

        this.issueSceneController = new IssueSceneController(this.baseController);
        this.makeIssueController = new MakeIssueController(this.baseController, this);
        this.projAuthSceneController = new ProjAuthSceneController(this.baseController);
        this.panel = new ProjectScenePanel(this);
    }

    public Issue[] getIssueList(){
        Issue issues[] = baseController.getIssueList();
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

    public void runProjAuthPanel() {
        projAuthSceneController.run();
        makeIssueController.dispose();
    }

    public void runMakeIssue(){
        makeIssueController.run();
    }

    public void makeIssueList(){
        this.panel.makeIssueList();
    }

    public void runIssueScene(int index) {
        if(issueIDs == null || index >= issueIDs.length || index < 0) {
            return;
        }
        
        Issue issues[] = this.baseController.getIssueList();
        for (Issue issue : issues) {
            if(issue.getID().getID() == issueIDs[index].getID()) {
                this.makeIssueController.dispose();
                this.issueSceneController.setProjectPanel(issue);
                return;
            }
        }
    }
}
