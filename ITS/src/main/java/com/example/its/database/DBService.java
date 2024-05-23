package com.example.its.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.authority.AuthorityDBService;
import com.example.its.database.issue.ISsueDBService;
import com.example.its.database.pirelation.PIRelationDBService;
import com.example.its.database.project.ProjectDBService;
import com.example.its.database.user.UserDBService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {
    private final ProjectDBService projectDBService;
    private final UserDBService userDBService;
    private final AuthorityDBService authDBService;
    private final ISsueDBService issueDBService;
    private final PIRelationDBService pIRelationDBService;

    //ProjectDB methods
    public ProjectID createProject(String title, String description, UserID adminID){
        return projectDBService.createProjectService(title, description, adminID);
    }

    public Project readProject(ProjectID projectID){
        return projectDBService.readProjectService(projectID);
    }

    public List<Project> readProjectList(UserID adminID){
        return projectDBService.readProjectListService(adminID);
    }

    public void updateProject(ProjectID projectID, String title, String description){
        projectDBService.updateProjectService(projectID, title, description);
    }
    
    public void deleteProjectService(ProjectID projectID){
        projectDBService.deleteProjectService(projectID);
    }


    //UserDB methods
    public Boolean checkRightPW(UserID userID, String inputPW){
        return userDBService.checkRightPWService(userID, inputPW);
    }

    public UserID createUser(String ID, String password){
        return userDBService.createUserService(ID, password);
    }

    public User readUserService(UserID user){
        return userDBService.readUserService(user);
    }

    public void updateUserService(UserID userID, String password, String newPW){
        userDBService.updateUserService(userID, password, newPW);
    }

    public void deleteUserSerivce(UserID userID){
        userDBService.deleteUserSerivce(userID);
    }



    //Authority methods
    // public int createAuthority(String userID, int projectID, int auth){
    //     return authDBService.createAuthorityService(userID, projectID, auth);
    // }

    // public HashMap<String, List<Integer>> readAuthorityListbyProject(ProjectID projectID){
    //     return authDBService.readAuthorityListbyProjectService(projectID);
    // }

    // public HashMap<Integer, List<Integer>> readAuthorityListbyUser(UserID userID){
    //     return authDBService.readAuthorityListbyUserService(userID);
    // }

    // public void deleteAuthority(int ID){
    //     authDBService.deleteAuthority(ID);
    // }



    //Issue methods
    public IssueID createIssue(ProjectID projectIDFK,String title, String description, UserID reporter, UserID assignee, UserID fixer, int type, int priority, int status){
        IssueID i = issueDBService.createIssueService(title, description, reporter, assignee, fixer, type, priority, status);
        pIRelationDBService.createPIRelationService(projectIDFK, i);
        return i;
    }

    // TODO comment 도 같이 불러오기...?
    public Issue readIssue(IssueID issueID){
        return issueDBService.readIssueService(issueID);
    }

    public List<Issue> readIssueList(ProjectID projectIDFK, UserID reporter, UserID assignee, Integer status, String sortOrder){
        return issueDBService.readIssueListService(projectIDFK, reporter, assignee, status, sortOrder);
    }

    public void updateIssueService(IssueID ID, String title, String description, UserID reporter, UserID assignee, UserID fixer, Integer type, Integer priority, Integer status){
        issueDBService.updateIssueService(ID, title, description, reporter, assignee, fixer, type, priority, status);
    }

    public void deleteIssue(IssueID ID){
        issueDBService.deleteIssueService(ID);
    }



}
