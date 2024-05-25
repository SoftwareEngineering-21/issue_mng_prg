package com.example.its.database.issue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.dataClassDB.IssueDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueDBService {
    private final IssueDBManager manager;

    private Issue IDBtoIssue(IssueDB idb){
        Issue newI = new Issue(new IssueID(idb.getID()), idb.getTitle(), idb.getDescription(), idb.getStatus(), new UserID(idb.getAssignee()), new UserID(idb.getReporter()), new UserID(idb.getFixer()), idb.getPriority());
        return newI;
    }

    public IssueID createIssueService(String title, String description, UserID reporter, UserID assignee, UserID fixer, int type, int priority, int status){
        Integer temp = manager.createIssueManager(title, description, description, title, description, type, priority, status);
        IssueID issueID = new IssueID(temp);
        return issueID;
    }

    public Issue readIssueService(IssueID issueID){
        IssueDB idb = manager.readIssueManager(issueID.getID());
        Issue i = IDBtoIssue(idb);
        return i;
    }

    public List<Issue> readIssueListService(ProjectID projectIDFK, UserID reporter, UserID assignee, Integer status, String sortOrder){
        List<IssueDB> iList = manager.readIssueListManager(projectIDFK.getID(), reporter.getID(), assignee.getID(), status, sortOrder);
        List<Issue> issues = new ArrayList<>();
        for (IssueDB issueDB : iList) {
            issues.add(IDBtoIssue(issueDB));
        }
        return issues;
    }

    public void updateIssueService(IssueID ID, String title, String description, UserID reporter, UserID assignee, UserID fixer, Integer type, Integer priority, Integer status){
        manager.updateIssueManager(ID.getID(), title, description, reporter.getID(), assignee.getID(), fixer.getID(), type, priority, status);
    }

    public void deleteIssueService(IssueID ID){
        manager.deleteIssueManager(ID.getID());
    }
}
