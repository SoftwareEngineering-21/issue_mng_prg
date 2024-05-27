package com.example.its.swingUI;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.Issue;

import java.util.ArrayList;

import com.example.its.dataClass.Comment;

import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.IssueID;

@Deprecated
public class TestController extends BaseController {
    ArrayList<User> userList = new ArrayList<>();

    ArrayList<User> testerList = new ArrayList<>();
    ArrayList<User> playerList = new ArrayList<>();
    ArrayList<User> developerList = new ArrayList<>();

    ArrayList<Project> projectList = new ArrayList<>();
    ArrayList<Issue> issueList = new ArrayList<>();

    @Override
    public boolean isExistID(String id) {
        for (User user : userList) {
            if(user.getID().getID() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean signUp(String id, String password) {
        userList.add(new User(new UserID(id)));
        return true;
    }

    @Override
    public boolean login(String id, String password) {
        if(id.isEmpty() || password.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public Project[] getProjectList() {
        return this.projectList.toArray(new Project[projectList.size()]);
    }

    @Override
    public boolean makeProject(String title, String Desc) {
        makeProject(title, Desc);
        return true;
    }

    @Override
    public boolean addTester(User id) {
        testerList.add(id);
        return true;
    }

    @Override
    public boolean addPlayer(User id) {
        playerList.add(id);
        return true;
    }

    @Override
    public boolean addDeveloper(User id) {
        developerList.add(id);
        return true;
    }

    @Override
    public User[] getTesterList() {
        return testerList.toArray(new User[testerList.size()]);
    }

    @Override
    public User[] getPlayerList() {
        return playerList.toArray(new User[playerList.size()]);
    }

    @Override
    public User[] getDeveloperList() {
        return developerList.toArray(new User[developerList.size()]);
    }

    @Override
    public Issue[] getIssueList() {
                if(issueList == null){
                    return null;
                }
        
                return issueList.toArray(new Issue[issueList.size()]);
    }

    @Override
    public boolean makeIssue(String title, String desc) {
        return true;
    }

    @Override
    public Comment[] getCommentList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentList'");
    }

    @Override
    public boolean addComment(String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addComment'");
    }
}
