package com.example.its.swingUI;

public abstract class IssueController {
    BaseController baseCon;
    IssueScenePanel panel;

    IssueController(BaseController baseCon){
        this.baseCon = baseCon;
        panel = new IssueScenePanel(this);
    }
}
