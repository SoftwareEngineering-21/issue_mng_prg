package com.example.its.swingUI;

public abstract class IssueSceneController {
    protected BaseFrameController baseCon;
    protected IssueScenePanel panel;

    IssueSceneController(BaseFrameController baseCon){
        this.baseCon = baseCon;
        panel = new IssueScenePanel(this);
    }

    void loadIssueInfo(){
        
    }
}
