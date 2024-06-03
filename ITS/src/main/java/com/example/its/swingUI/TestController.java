package com.example.its.swingUI;

import com.example.its.dataClass.*;
import com.example.its.dataClass.Issue.PriorityID;
import com.example.its.dataClass.Issue.StatusID;
import com.example.its.dataClass.Issue.TypeID;
import com.example.its.state.StateManager;

import java.sql.Timestamp;
import java.util.ArrayList;

@Deprecated
public class TestController extends BaseController {
    ArrayList<UserID> userList = new ArrayList<>();

    ArrayList<UserID> testerList = new ArrayList<UserID>();
    ArrayList<UserID> playerList = new ArrayList<UserID>();
    ArrayList<UserID> developerList = new ArrayList<UserID>();

    ArrayList<Project> projectList = new ArrayList<Project>();
    ArrayList<Project> adminProjectList = new ArrayList<Project>();
    ArrayList<Issue> issueList = new ArrayList<Issue>();
    ArrayList<Comment> commentList = new ArrayList<>();

    public TestController(StateManager stateManager) {
        super(stateManager);
    }

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

        this.stateManager.setUser(new UserID(id));
        return true;
    }

    @Override
    public boolean logout() {
        this.stateManager.setUser(null);
        return true;
    }

    @Override
    public Project[] getProjectList() {
        return this.projectList.toArray(new Project[] {});
    }

    @Override
    public boolean makeProject(String title, String Desc) {
        adminProjectList.add(new Project(new ProjectID(adminProjectList.size()), title, Desc, stateManager.getUser()));
        return true;
    }

    @Override
    public Project getProject(ProjectID projectId) {
        if(adminProjectList != null){
            for(Project project : adminProjectList){
                if(project.getProjectID() == projectId){
                    return project;
                }
            }
        }
        if(projectList != null){
            for(Project project : projectList){
                if(project.getProjectID() == projectId){
                    return project;
                }
            }
        }

        return null;
    }

    @Override
    public Project openProject(ProjectID projectId) {
        Project project = getProject(projectId);
        if(project != null){
            this.stateManager.setProject(projectId);
            return project;
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
    public boolean makeIssue(String title, String desc, int type, int priority, String commentDesc) {
        issueList.add(new Issue(new IssueID(issueList.size()), title, desc, StatusID.NEW, TypeID.values()[type], PriorityID.values()[priority], null, stateManager.getUser(), null));
        return true;
    }

    @Override
    public Issue getIssue(IssueID id) {
        if(issueList != null)   {
            for(Issue issue : issueList){
                if(issue.getID() == id){
                    return issue;
                }
            }
        }

        return null;
    }

    @Override
    public Issue openIssue(IssueID id) {
        Issue issue = getIssue(id);
        if(issue != null){
            this.stateManager.setIssue(issue.getID());
            return issue;
        }
        return null;
    }

    @Override
    public boolean updateIssue(String assignee, String status, String CommentDesc) {
        return false;
    }

    @Override
    public Comment[] getCommentList() {
        if(commentList == null){
            return null;
        }
        return commentList.toArray(new Comment[]{});
    }

    @Override
    public boolean addComment(String desc) {
        commentList.add(new Comment(new CommentID(commentList.size()), desc, new Timestamp(System.currentTimeMillis()), stateManager.getUser()));
        return true;
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
