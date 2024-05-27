package com.example.its.swingUI;

import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.User;

public abstract class ServiceLayer {
    protected BaseController baseController;
    protected LoginController loginController;

    @Autowired
    protected ServiceLayer() {
        this.baseController = new BaseController();
        this.loginController = new LoginController(this);
    }

    //유저 관련
    public abstract boolean login(String id, String password);

    //프로젝트 관련
    public abstract Project[] getProjectList();
    public abstract boolean makeProject(String title, String Desc);

    public abstract void addTester(User id);
    public abstract void addPlayer(User id);
    public abstract void addDeveloper(User id);

    public abstract User[] getTesterList();
    public abstract User[] getPlayerList();
    public abstract User[] getDeveloperList();

    //이슈 관련
    public abstract Issue[] getIssueList();
    public abstract boolean makeIssue();


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
