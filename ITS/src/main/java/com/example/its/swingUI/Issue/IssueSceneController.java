package com.example.its.swingUI.Issue;

import com.example.its.dataClass.Issue;
import com.example.its.swingUI.BaseController;

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
