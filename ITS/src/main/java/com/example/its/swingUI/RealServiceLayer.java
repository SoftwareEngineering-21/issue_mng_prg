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
        return userService.login(id, password);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIssueList'");
    }

    @Override
    public void makeIssue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeIssue'");
    }
}
