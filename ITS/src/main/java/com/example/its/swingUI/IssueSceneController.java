package com.example.its.swingUI;

public class IssueSceneController {
    protected BaseController baseController;
    protected IssueScenePanel panel;

    IssueSceneController(BaseController baseController){
        this.baseController = baseController;
        panel = new IssueScenePanel(this);
    }

    void loadIssueInfo(){
        
    }
}
