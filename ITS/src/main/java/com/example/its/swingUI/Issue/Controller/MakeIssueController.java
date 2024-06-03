package com.example.its.swingUI.Issue.Controller;

import com.example.its.swingUI.BaseController;
import com.example.its.swingUI.Issue.MakeIssueFrame;
import com.example.its.swingUI.Project.Controller.ProjectSceneController;

public class MakeIssueController {
    BaseController baseController;
    ProjectSceneController projectSceneController;

    MakeIssueFrame frame;
    
    public MakeIssueController(BaseController baseController, ProjectSceneController projectSceneController) {
        this.baseController = baseController;
        this.projectSceneController = projectSceneController;

        frame = new MakeIssueFrame(this);
    }

    public boolean MakeIssue(String title, String desc, int type, int priority, String CommentDesc){
        boolean result = this.baseController.makeIssue(title, desc, type, priority, CommentDesc);
        this.projectSceneController.makeIssueList();
        return result;
    }

    public void run(){
        this.frame.reset();
        this.frame.setVisible(true);
    }

    public void dispose(){
        this.frame.dispose();
    }
}
