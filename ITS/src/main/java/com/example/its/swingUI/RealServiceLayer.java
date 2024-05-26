package com.example.its.swingUI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;

import com.example.its.logic.UserService;
import com.example.its.logic.ProjectService;

@Component
public class RealServiceLayer extends ServiceLayer {
    private UserID userID;

    protected UserService userService;
    protected ProjectService projectService;
    //protected IssueService issueService;

    @Autowired
    RealServiceLayer(UserService userService, ProjectService projectService){
        super();
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public boolean login(String id, String password) {
        if(this.userService == null){
            return false;
        }

        if(this.userService.login(id, password)){
            return true;
        }

        return false;
    }

    @Override
    public Project[] getProjectList() {
        if(projectService == null){
            System.out.println("Error! projectService is null");
            return null;
        }

        List<Project> list = projectService.readProjects(new UserID("test"));
        return list.toArray(new Project[list.size()]);
    }

    @Override
    public boolean makeProject(String title, String Desc) {
        if(this.projectService == null){
            return false;
        }
        
        try{
            this.projectService.createProject(this.userID, title, Desc);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public void addTester(User id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTester'");
    }

    @Override
    public void addPlayer(User id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPlayer'");
    }

    @Override
    public void addDeveloper(User id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDeveloper'");
    }

    @Override
    public User[] getTesterList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTesterList'");
    }

    @Override
    public User[] getPlayerList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerList'");
    }

    @Override
    public User[] getDeveloperList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeveloperList'");
    }

    @Override
    public Issue[] getIssueList() {
        if(this.projectService == null){
            return null;
        }

        List<Issue> issueList = null;
        //issueList = this.projectService.getIssueList();

        if(issueList == null){
            return null;
        }
        return issueList.toArray(new Issue[issueList.size()]);
    }

    @Override
    public boolean makeIssue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeIssue'");
    }
}
