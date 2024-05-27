package com.example.its.swingUI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.its.dataClass.Comment;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;

import com.example.its.logic.UserService;
import com.example.its.logic.ProjectService;

@Component
public class RealServiceLayer extends ServiceLayer {
    private UserID userId;

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
    public boolean isExistID(String id) {
        return false;
    }

    @Override
    public boolean signUp(String id, String password) {
        //return userService.createUser(id, password);
        return true;
    }

    @Override
    public Project[] getProjectList() {
        if(projectService == null){
            System.out.println("Error! projectService is null");
            return null;
        }

        List<Project> list = projectService.readProjects(userId);
        return list.toArray(new Project[list.size()]);
    }

    @Override
    public boolean makeProject(String title, String Desc) {
        if(this.projectService == null){
            return false;
        }
        
        try{
            this.projectService.createProject(this.userId, title, Desc);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean addTester(User id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTester'");
    }

    @Override
    public boolean addPlayer(User id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPlayer'");
    }

    @Override
    public boolean addDeveloper(User id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDeveloper'");
    }

    @Override
    public User[] getTesterList(ProjectID projectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTesterList'");
    }

    @Override
    public User[] getPlayerList(ProjectID projectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlayerList'");
    }

    @Override
    public User[] getDeveloperList(ProjectID projectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeveloperList'");
    }

    @Override
    public Issue[] getIssueList(ProjectID projectId) {
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
    public boolean makeIssue(String title, String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeIssue'");
    }

    @Override
    public Comment[] getCommentList(IssueID issueId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentList'");
    }

    @Override
    public boolean addComment(String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addComment'");
    }

    @Override
    public boolean logout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }
}
