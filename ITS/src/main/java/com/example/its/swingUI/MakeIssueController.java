package com.example.its.swingUI;

public class MakeIssueController {
    BaseController baseController;
    ProjectSceneController projectSceneController;

    MakeIssueFrame frame;
    
    MakeIssueController(BaseController baseController, ProjectSceneController projectSceneController) {
        this.baseController = baseController;
        this.projectSceneController = projectSceneController;

        frame = new MakeIssueFrame(this);
    }

    public boolean MakeIssue(String title, String desc, int priority){
        boolean result = this.baseController.makeIssue(title, desc, priority);
        this.projectSceneController.makeIssueList();
        return result;
    }

    public void run(){
        this.frame.setVisible(true);
    }

    public void dispose(){
        this.frame.dispose();
    }
}
