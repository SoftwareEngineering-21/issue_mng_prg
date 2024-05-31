package com.example.its.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;

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

    public void createIssue(ProjectID projectID, String title, String desc, UserID reporter, Issue.TypeID type, Issue.PriorityID priority) {
        IssueID p = service.createIssue(projectID, title, desc, null, null, null, type, priority, Issue.StatusID.NEW);
        String commentDesc = reporter.getID() + "make issue";
        service.createComment(p, commentDesc, reporter);

    }

    public Issue readIssue(IssueID issueID){
        return service.readIssue(issueID);
    }

    public UserID recommendDeveloper(ProjectID projectID, Issue.StatusID status, Issue.TypeID type){
        return service.recommendDev(projectID, status, type);
    }

    // TODO 고민해볼 것 - user 권한 검사하는건 controller 역할? 그렇다면 이 주석 지우고 update 기능 그대로 쓰면 됨.
    public void updateIssue(UserID author, IssueID issueID, String title, String description, UserID reporter, UserID assignee, UserID fixer, Issue.TypeID type, Issue.PriorityID priority, Issue.StatusID status){
        service.updateIssue(issueID, title, description, reporter, assignee, fixer, type == null ? null : type.ordinal(), priority == null ? null : priority.ordinal(), status == null ? null : status.ordinal());
        String commentDesc = reporter.getID() + "update issue";
        service.createComment(issueID, commentDesc, author);
    }

}
