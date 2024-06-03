package com.example.its.swingUI;

import javax.swing.JPanel;

import com.example.its.dataClass.*;
import com.example.its.logic.authorityHandling.userAuth;
import com.example.its.state.StateManager;
import com.example.its.swingUI.Login.LoginFrameController;

import java.util.List;


public abstract class BaseController {
    protected BaseFrameController baseFrameController;
    protected LoginFrameController loginFrameController;

    protected final StateManager stateManager;

    protected UserID userID() { return this.stateManager.getUser();}
    protected ProjectID projectID() { return this.stateManager.getProject();}
    protected IssueID issueID() { return this.stateManager.getIssue();}
    protected List<userAuth> getUserAuths() { return this.stateManager.getUserAuthes();}

    protected BaseController(StateManager statusManager) {
        this.stateManager = statusManager;

        this.baseFrameController = new BaseFrameController(this);
        this.loginFrameController = new LoginFrameController(this);
    }

    //유저 관련
    public abstract boolean isExistID(String id);
    public abstract boolean signUp(String id, String password);

    public abstract boolean login(String id, String password);
    public abstract boolean logout();

    //프로젝트 관련
    public abstract Project[] getProjectList();
    public abstract Project[] getAdminProjectList();
    public abstract boolean makeProject(String title, String Desc);
    public abstract Project getProject(ProjectID projectId);
    public abstract Project openProject(ProjectID projectId);

    public void closeProject() {
        this.stateManager.setProject(null);
    }

    public abstract boolean addTester(UserID id);
    public abstract boolean addPlayer(UserID id);
    public abstract boolean addDeveloper(UserID id);

    public abstract boolean deleteTester(UserID id);
    public abstract boolean deletePlayer(UserID id);
    public abstract boolean deleteDeveloper(UserID id);

    public abstract UserID[] getTesterList();
    public abstract UserID[] getPlayerList();
    public abstract UserID[] getDeveloperList();

    //이슈 관련
    public abstract Issue[] getIssueList();
    public abstract boolean makeIssue(String title, String desc, int type, int priority, String commentDesc);
    public abstract Issue getIssue(IssueID id);
    public abstract Issue openIssue(IssueID id);
    public abstract boolean updateIssue(String assignee, String status, String CommentDesc);

    public void closeIssue() {
        this.stateManager.setIssue(null);
    }

    //코멘트 관련
    public abstract Comment[] getCommentList();
    public abstract boolean addComment(String desc);

    //BasePanel 관련
    public void setBasePanel(JPanel panel){
        this.baseFrameController.setPanel(panel);
    }

    public void runBase(){
        if(!this.baseFrameController.isEmptyMainPanel()){
            this.baseFrameController.run();
        }
    }

    public void run(){
        this.loginFrameController.run();
    }
}
