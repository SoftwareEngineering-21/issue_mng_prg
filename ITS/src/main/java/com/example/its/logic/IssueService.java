package com.example.its.logic;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Issue readIssueById(IssueID issueId) {
        return service.readIssue(issueId);
    }

    public void createIssue(ProjectID projectID, String title, String desc, UserID reporter, Issue.TypeID type, Issue.PriorityID priority) {
        service.createIssue(projectID, title, desc, null, null, null, type, priority, Issue.StatusID.NEW);
    }
}
