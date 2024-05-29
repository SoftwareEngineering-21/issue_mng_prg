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

    void setProjectPanel(Issue issue){ 
        this.panel.setIssueInfo(issue);
        this.baseController.setBasePanel(panel);
    }
}
