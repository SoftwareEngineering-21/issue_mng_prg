package com.example.its.database.issue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.EnumUtility;
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
        return new Issue(new IssueID(idb.getID()), idb.getTitle(), idb.getDescription(), EnumUtility.fromValue(Issue.StatusID.class,idb.getStatus()),EnumUtility.fromValue(Issue.TypeID.class, idb.getType()), EnumUtility.fromValue(Issue.PriorityID.class, idb.getPriority()),(idb.getAssignee()!= null) ? new UserID(idb.getAssignee()):null , new UserID(idb.getReporter()),(idb.getFixer()!=null)? new UserID(idb.getFixer()): null);
    }

    public IssueID createIssueService(String title, String description, UserID reporter, UserID assignee, UserID fixer, Issue.TypeID type, Issue.PriorityID priority, Issue.StatusID status){
        String fixerID = (fixer != null) ? fixer.getID() : null;
        String assigneeID = (assignee != null) ? assignee.getID() : null;
        Integer temp = manager.createIssueManager(title, description, reporter.getID(), assigneeID, fixerID, type.ordinal(), priority.ordinal(), status.ordinal());
        return new IssueID(temp);
    }

    public Issue readIssueService(IssueID issueID){
        IssueDB idb = manager.readIssueManager(issueID.getID());
        return IDBtoIssue(idb);
    }


    public List<Issue> readIssueListService(ProjectID projectIDFK, UserID reporter, UserID assignee, Integer status, String sortOrder){
        List<IssueDB> iList = manager.readIssueListManager(projectIDFK.getID(), (reporter!=null)?reporter.getID():null, (assignee != null) ? assignee.getID() : null, status, sortOrder);
        System.out.println(sortOrder);
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
        String reporterID = (reporter != null) ? reporter.getID() : null;
        String fixerID = (fixer != null) ? fixer.getID() : null;
        String assigneeID = (assignee != null) ? assignee.getID() : null;
        manager.updateIssueManager(ID.getID(), title, description, reporterID, assigneeID, fixerID, type, priority, status);
    }

    public void deleteIssueService(IssueID ID){
        manager.deleteIssueManager(ID.getID());
    }
}
