package com.example.its.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Authority.AuthorityID;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import com.example.its.logic.authorityHandling.userAuth;
import com.example.its.logic.authorityHandling.userDeveloper;
import com.example.its.logic.authorityHandling.userPlayer;
import com.example.its.logic.authorityHandling.userTester;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final DBService service;

    /**
     * @param projectID not null
     * @param reporter nullable
     * @param assignee nullable
     * @param status nullable
     * @param sortOrder null -> desc, createdAt, status
     */
    public List<Issue> readIssueList(ProjectID projectID, UserID reporter, UserID assignee, Issue.StatusID status, String sortOrder){
        return service.readIssueList(projectID,reporter, assignee, status == null ? null : status.ordinal(),sortOrder);
    }

    /**
     * @param authes
     * @param commentText
     * @param projectID
     * @param title
     * @param desc
     * @param reporter
     * @param type
     * @param priority
     * @param date
     */
    public void createIssue(List<userAuth> authes,String commentText, ProjectID projectID, String title, String desc, UserID reporter, Issue.TypeID type, Issue.PriorityID priority, Date date) {
        for (userAuth a : authes){
            if(a.isAvailable(null, reporter, null)){
                Issue newI = a.perform(null, priority, type, reporter, null, null);
                IssueID issueID = service.createIssue(projectID, title, desc, newI.getReporter(), null, null, newI.getType(), newI.getPriority(), newI.getStatus());
                String commentDesc = reporter.getID() + "create issue\n"+commentText;
                service.createComment(issueID, commentDesc, reporter, date);
            }
        }

    }

    public Issue readIssue(IssueID issueID){
        return service.readIssue(issueID);
    }

    public UserID recommendDeveloper(ProjectID projectID, Issue.TypeID type){
        return service.recommendDev(projectID, Issue.StatusID.CLOSED, type);
    }

    public void updateIssue(List<userAuth> authes,String commentText, UserID author, IssueID issueID, String title, String description, UserID reporter, UserID assignee, UserID fixer, Issue.TypeID type, Issue.PriorityID priority, Issue.StatusID status, Date date){
        Issue preIssue = service.readIssue(issueID);
        for(userAuth a : authes){
            if(a.isAvailable(preIssue, null, assignee)){
                Issue updateI = a.perform(status, priority, type, reporter, assignee, fixer);
                service.updateIssue(issueID, title, description, updateI.getReporter(), updateI.getAssignee(), updateI.getFixer() == null ? null : updateI.getFixer(), updateI.getType().ordinal(), updateI.getPriority().ordinal(), updateI.getStatus().ordinal());
                String commentDesc = reporter.getID() + "update issue" + commentText;
                service.createComment(issueID, commentDesc, author, date);
            }

        }
        
    }

    public List<userAuth> makeAuthList(ProjectID projectID, UserID userID){
        Authority a = service.readAuthorityListbyAll(userID, projectID);
        List<userAuth> returnAuthes = new ArrayList<>();
        
        if(a.getAuthority().contains(AuthorityID.PLAYER)){
            returnAuthes.add(new userPlayer());
        }
        if(a.getAuthority().contains(AuthorityID.DEVELOPER)){
            returnAuthes.add(new userDeveloper());
        }
        if(a.getAuthority().contains(AuthorityID.TESTER)){
            returnAuthes.add(new userTester());
        }

        return returnAuthes;
        
    }

}
