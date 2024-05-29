package com.example.its.database.issue;

import java.util.ArrayList;
import java.util.List;

import com.example.its.dataClass.*;
import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.IssueDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueDBService {
    private final IssueDBManager manager;

    private Issue IDBtoIssue(IssueDB idb){
        return new Issue(new IssueID(idb.getID()), idb.getTitle(), idb.getDescription(), EnumUtility.fromValue(Issue.StatusID.class,idb.getStatus()),EnumUtility.fromValue(Issue.TypeID.class, idb.getType()), EnumUtility.fromValue(Issue.PriorityID.class, idb.getPriority()),new UserID(idb.getAssignee()), new UserID(idb.getReporter()),new UserID(idb.getFixer()));
    }

    public IssueID createIssueService(String title, String description, UserID reporter, UserID assignee, UserID fixer, Issue.TypeID type, Issue.PriorityID priority, Issue.StatusID status){
        Integer temp = manager.createIssueManager(title, description, description, title, description, type.ordinal(), priority.ordinal(), status.ordinal());
        IssueID issueID = new IssueID(temp);
        return issueID;
    }

    public Issue readIssueService(IssueID issueID){
        IssueDB idb = manager.readIssueManager(issueID.getID());
        return IDBtoIssue(idb);
    }

    public List<Issue> readIssueListService(ProjectID projectIDFK, UserID reporter, UserID assignee, Integer status, String sortOrder){
        List<IssueDB> iList = manager.readIssueListManager(projectIDFK.getID(), reporter.getID(), assignee.getID(), status, sortOrder);
        if(iList==null || iList.isEmpty()){
            return null;
        }
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
