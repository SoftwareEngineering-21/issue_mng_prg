package com.example.its.swingUI;

public abstract class IssueController {
    protected BaseController baseCon;
    protected IssueScenePanel panel;

    IssueController(BaseController baseCon){
        this.baseCon = baseCon;
        panel = new IssueScenePanel(this);
    }

    void loadIssueInfo(){
        
    }
}
