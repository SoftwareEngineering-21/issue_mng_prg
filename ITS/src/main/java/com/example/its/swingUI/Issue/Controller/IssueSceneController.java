package com.example.its.swingUI.Issue.Controller;

import com.example.its.dataClass.Comment;
import com.example.its.dataClass.Issue;
import com.example.its.swingUI.BaseController;
import com.example.its.swingUI.Issue.IssueScenePanel;

public class IssueSceneController {
    protected BaseController baseController;
    protected IssueScenePanel panel;

    public IssueSceneController(BaseController baseController){
        this.baseController = baseController;
        panel = new IssueScenePanel(this);
    }

    public void setBasePanel(Issue issue) {
        this.panel.setIssueInfo(issue);
        this.panel.makeCommentList();
        this.baseController.setBasePanel(panel);
    }

    public Comment[] getCommentList() {
        return this.baseController.getCommentList();
    }

    public boolean addComment(String desc) {
        if(this.baseController.addComment(desc)){
            this.panel.makeCommentList();
            return true;
        }
        return false;
    }
}
