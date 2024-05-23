package com.example.its.swingUI;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;

public abstract class ProjSceneController {
    protected BaseController baseCon;
    protected IssueController issueController;

    protected ProjectScenePanel panel;

    public abstract Issue[] getIssueList();

    public void setProjPanel(Project project){
        setBasePanel();
        panel.setProjInfo(project);
    }


    ProjSceneController(BaseController baseCon){
        this.baseCon = baseCon;
        panel = new ProjectScenePanel(this);
    }

    public void setBasePanel(){
        baseCon.setPanel(panel);
    }
}
