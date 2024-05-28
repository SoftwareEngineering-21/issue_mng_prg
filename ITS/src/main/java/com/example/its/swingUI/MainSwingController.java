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
import com.example.its.status.StatusManager;
import com.example.its.logic.ProjectService;

@Component
public class MainSwingController extends BaseController {
    protected UserService userService;
    protected ProjectService projectService;
    //protected IssueService issueService;

    @Autowired
    MainSwingController(UserService userService, ProjectService projectService){
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

        List<Project> list = projectService.readProjects(StatusManager.getInstance().getUser().getID());
        return list.toArray(new Project[list.size()]);
    }

    @Override
    public boolean makeProject(String title, String Desc) {
        if(this.projectService == null){
            return false;
        }
        
        try{
            this.projectService.createProject(StatusManager.getInstance().getUser().getID(), title, Desc);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean addTester(User id) {
        return true;
    }

    @Override
    public boolean addPlayer(User id) {
        return true;
    }

    @Override
    public boolean addDeveloper(User id) {
        return true;
    }

    @Override
    public User[] getTesterList() {
        return null;
    }

    @Override
    public User[] getPlayerList() {
        return null;
    }

    @Override
    public User[] getDeveloperList() {
        return null;
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
    public boolean makeIssue(String title, String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeIssue'");
    }

    @Override
    public boolean addComment(String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addComment'");
    }

    @Override
    public boolean logout() {
        userService.logout();
        return true;
    }

    @Override
    public Comment[] getCommentList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentList'");
    }

    @Override
    public boolean deleteTester(User id) {
        return false;
    }

    @Override
    public boolean deletePlayer(User id) {
        return false;
    }

    @Override
    public boolean deleteDeveloper(User id) {
        return false;
    }

    @Override
    public Project[] getAdminProjectList() {
        List<Project> projects = this.projectService.readAdminProjects(StatusManager.getInstance().getUser().getID());
        if(projects == null){
            return null;
        }
        return projects.toArray(new Project[projects.size()]);
    }
}