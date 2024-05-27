package com.example.its.swingUI;

import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.its.dataClass.Comment;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;

public abstract class ServiceLayer {
    protected BaseController baseController;
    protected LoginController loginController;

    protected UserID userId;

    @Autowired
    protected ServiceLayer() {
        this.baseController = new BaseController();
        this.loginController = new LoginController(this);
    }

    //유저 관련
    public abstract boolean isExistID(String id);
    public abstract boolean signUp(String id, String password);

    public abstract boolean login(String id, String password);
    public abstract boolean logout();

    //프로젝트 관련
    public abstract Project[] getProjectList();
    public abstract boolean makeProject(String title, String Desc);

    public abstract boolean addTester(User id);
    public abstract boolean addPlayer(User id);
    public abstract boolean addDeveloper(User id);

    public abstract User[] getTesterList(ProjectID projectId);
    public abstract User[] getPlayerList(ProjectID projectId);
    public abstract User[] getDeveloperList(ProjectID projectId);

    //이슈 관련
    public abstract Issue[] getIssueList(ProjectID projectId);
    public abstract boolean makeIssue(String title, String desc);

    //코멘트 관련
    public abstract Comment[] getCommentList(IssueID issueId);
    public abstract boolean addComment(String desc);

    //BasePanel 관련
    public void setBasePanel(JPanel panel){
        this.baseController.setPanel(panel);
    }

    public void runBase(){
        if(!this.baseController.isEmptyMainPanel()){
            this.baseController.run();
        }
    }

    public void run(){
        this.loginController.run();
    }
}
