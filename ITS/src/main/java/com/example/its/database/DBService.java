package com.example.its.database;

import java.util.List;

import com.example.its.dataClass.*;
import org.springframework.stereotype.Service;

import com.example.its.database.authority.AuthorityDBService;
import com.example.its.database.comment.CommentDBService;
import com.example.its.database.icrelation.ICRelationDBService;
import com.example.its.database.issue.IssueDBService;
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
    private final IssueDBService issueDBService;
    private final PIRelationDBService pIRelationDBService;
    private final CommentDBService commentDBService;
    private final ICRelationDBService icRelationDBService;

    //ProjectDB methods
    public ProjectID createProject(String title, String description, UserID adminID){
        return projectDBService.createProjectService(title, description, adminID);
    }

    public Project readProject(ProjectID projectID){
        return projectDBService.readProjectService(projectID);
    }

    public List<Project> readProjectList(UserID userID){
        return projectDBService.readProjectListService(userID);
    }

    public List<Project> readAdminProjectList(UserID userID){return projectDBService.readAdminProjectListService(userID);}

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

    public User readUser(UserID user){
        return userDBService.readUserService(user);
    }

    public UserSession readUserSession(UserID userID){
        return userDBService.readUserSessionService(userID);
    }

    public void updateUserService(UserID userID, String password, String newPW){
        userDBService.updateUserService(userID, password, newPW);
    }

    public void deleteUserSerivce(UserID userID){
        userDBService.deleteUserSerivce(userID);
    }



    //Authority methods
    public void createAuthority(UserID userID, ProjectID projectID, int auth){
        authDBService.createAuthorityService(userID, projectID, auth);
    }

    public List<List<UserID>> readAuthorityListbyProject(ProjectID projectID){
        return authDBService.readAuthorityListbyProjectService(projectID);
    }

    public Authority readAuthorityListbyAll(UserID userID, ProjectID projectID){
        return authDBService.readAuthorityListbyAllService(userID, projectID);
    }

    public void deleteAuthority(UserID userID, ProjectID projectID, int auth){
        authDBService.deleteAuthority(userID, projectID, auth);
    }



    //Issue methods
    public IssueID createIssue(ProjectID projectIDFK,String title, String description, UserID reporter, UserID assignee, UserID fixer, Issue.TypeID type, Issue.PriorityID priority, Issue.StatusID status){
        IssueID i = issueDBService.createIssueService(title, description, reporter, assignee, fixer, type, priority, status);
        pIRelationDBService.createPIRelationService(projectIDFK, i);
        return i;
    }

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



    //Comment method
    public CommentID createComment(IssueID issueID, String text, UserID author){

        CommentID newC = commentDBService.createCommentService(text, author);
        icRelationDBService.createICRelationService(issueID, newC);
        return newC;
    }

    public Comment readComment(CommentID commentID){
        return commentDBService.readCommentService(commentID);
    }

    public List<Comment> readCommentList(IssueID issueID){
        return commentDBService.readCommentListService(issueID);
    }
    
    public void updateComment(CommentID commentID, String text){
        commentDBService.updateCommentService(commentID, text);
    }

    public void deleteComment(CommentID commentID){
        commentDBService.deleteCommentService(commentID);
    }
}
