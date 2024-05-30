package com.example.its.swingUI;

import com.example.its.dataClass.*;
import com.example.its.dataClass.Issue.PriorityID;
import com.example.its.dataClass.Issue.StatusID;
import com.example.its.dataClass.Issue.TypeID;

import java.sql.Timestamp;
import java.util.ArrayList;

@Deprecated
public class TestController extends BaseController {
    User user;
    ProjectID projectId;
    IssueID issueId;

    ArrayList<UserID> userList = new ArrayList<>();

    ArrayList<UserID> testerList = new ArrayList<UserID>();
    ArrayList<UserID> playerList = new ArrayList<UserID>();
    ArrayList<UserID> developerList = new ArrayList<UserID>();

    ArrayList<Project> projectList = new ArrayList<Project>();
    ArrayList<Project> adminProjectList = new ArrayList<Project>();
    ArrayList<Issue> issueList = new ArrayList<Issue>();
    ArrayList<ArrayList<Comment>> commentList = new ArrayList<ArrayList<Comment>>();

    @Override
    public boolean isExistID(String id) {
        for (UserID user : userList) {
            if(user.getID() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean signUp(String id, String password) {
        userList.add(new UserID(id));
        return true;
    }

    @Override
    public boolean login(String id, String password) {
        if(id.isEmpty() || password.isEmpty()){
            return false;
        }

        user = new User(new UserID(id));
        return true;
    }

    @Override
    public boolean logout() {
        user = null;
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
    public Project getProject(ProjectID projectId) {
        if(projectList == null){
            return null;
        }

        for(Project project : projectList){
            if(project.getProjectID() == projectId){
                return project;
            }
        }

        return null;
    }

    @Override
    public boolean addTester(UserID id) {
        testerList.add(id);
        return true;
    }

    @Override
    public boolean addPlayer(UserID id) {
        playerList.add(id);
        return true;
    }

    @Override
    public boolean addDeveloper(UserID id) {
        developerList.add(id);
        return true;
    }

    @Override
    public UserID[] getTesterList() {
        if(testerList.size() <= 0) {
            return null;
        }
        return testerList.toArray(new UserID[]{});
    }

    @Override
    public UserID[] getPlayerList() {
        if(playerList.size() <= 0) {
            return null;
        }
        return playerList.toArray(new UserID[] {});
    }

    @Override
    public UserID[] getDeveloperList() {
        if(developerList.size() <= 0) {
            return null;
        }
        return developerList.toArray(new UserID[] {});
    }

    @Override
    public Issue[] getIssueList() {
            if(issueList == null){
                return null;
            }
    
            return issueList.toArray(new Issue[]{});
    }

    @Override
    public boolean makeIssue(String title, String desc, int priority) {
        issueList.add(new Issue(new IssueID(issueList.size()), title, desc, StatusID.OPEN, TypeID.TASK, PriorityID.MAJOR, null, user.getID(), null));
        return true;
    }

    @Override
    public Comment[] getCommentList() {
        for(int i = 0; i < issueList.size(); i++){
            if(issueList.get(i).getID() == issueId){
                return commentList.get(i).toArray(new Comment[] {});
            }
        }

        return null;
    }

    @Override
    public boolean addComment(String desc) {
        int index = -1;
        for(int i = 0; i < issueList.size(); i++){
            if(issueList.get(i).getID() == issueId){
                index = i;
                break;
            }
        }
        if(index == -1){
            return false;
        }

        while(commentList.size() <= index){
            commentList.add(new ArrayList<>());
        }

        return commentList.get(index).add(new Comment(new CommentID(index), desc, null, this.user.getID()));
    }

    @Override
    public boolean deleteTester(UserID id) {
        testerList.remove(id);
        return true;
    }

    @Override
    public boolean deletePlayer(UserID id) {
        playerList.remove(id);
        return true;
    }

    @Override
    public boolean deleteDeveloper(UserID id) {
        developerList.remove(id);
        return true;
    }

    @Override
    public Project[] getAdminProjectList() {
        return adminProjectList.toArray(new Project[] {});
    }
}
