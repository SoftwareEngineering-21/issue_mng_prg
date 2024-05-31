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
        service.createIssue(projectID, title, desc, null, null, null, type, priority, Issue.StatusID.NEW);
    }

    public Issue readIssue(IssueID issueID){
        return service.readIssue(issueID);
    }

    public UserID recommendDeveloper(ProjectID projectID, Issue.StatusID status, Issue.TypeID type){
        return service.recommendDev(projectID, status, type);
    }

}
