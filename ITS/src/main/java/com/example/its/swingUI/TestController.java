package com.example.its.swingUI;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;

import java.util.ArrayList;

import com.example.its.dataClass.Comment;

@Deprecated
public class TestController extends BaseController {
    ArrayList<User> userList = new ArrayList<>();

    ArrayList<User> testerList = new ArrayList<User>();
    ArrayList<User> playerList = new ArrayList<User>();
    ArrayList<User> developerList = new ArrayList<User>();

    ArrayList<Project> projectList = new ArrayList<Project>();
    ArrayList<Project> adminProjectList = new ArrayList<Project>();
    ArrayList<Issue> issueList = new ArrayList<Issue>();
    ArrayList<ArrayList<Comment>> commentList = new ArrayList<ArrayList<Comment>>();

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
        adminProjectList.add(new Project(new ProjectID(adminProjectList.size()), title, Desc, null));
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
        if(testerList.size() <= 0) {
            return null;
        }
        return testerList.toArray(new User[testerList.size()]);
    }

    @Override
    public User[] getPlayerList() {
        if(playerList.size() <= 0) {
            return null;
        }
        return playerList.toArray(new User[playerList.size()]);
    }

    @Override
    public User[] getDeveloperList() {
        if(developerList.size() <= 0) {
            return null;
        }
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
    public boolean makeIssue(String title, String desc, int priority) {
        issueList.add(new Issue(new IssueID(issueList.size()), title, desc, 
            0, null, new UserID("Wow"), null, priority));
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

    @Override
    public boolean deleteTester(User id) {
        testerList.remove(id);
        return true;
    }

    @Override
    public boolean deletePlayer(User id) {
        playerList.remove(id);
        return true;
    }

    @Override
    public boolean deleteDeveloper(User id) {
        developerList.remove(id);
        return true;
    }

    @Override
    public Project[] getAdminProjectList() {
        return adminProjectList.toArray(new Project[adminProjectList.size()]);
    }
}
