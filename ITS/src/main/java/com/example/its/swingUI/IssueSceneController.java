package com.example.its.swingUI;

import com.example.its.dataClass.Issue;

public class IssueSceneController {
    protected BaseController baseController;
    protected IssueScenePanel panel;

    IssueSceneController(BaseController baseController){
        this.baseController = baseController;
        panel = new IssueScenePanel(this);
    }

    void loadIssueInfo(){
        
    }

    Issue[] getIssueList() {
        return null;
    }

    void setProjectPanel(Issue issue){ 
        this.panel.setIssueInfo(issue);
        this.panel.makeCommentList();
        this.baseController.setBasePanel(panel);
    }
}
