package com.example.its.database.issue;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.IssueDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueDBManager {
    private final IssueDBMapper mapper;

    public Integer createIssueManager(String title, String description, String reporter, String assignee, String fixer, int type, int priority, int status){
        IssueDB issue = new IssueDB(title, description, reporter, assignee, fixer, type, priority, status);
        mapper.createIssue(issue);
        return issue.getID();
    }

    public IssueDB readIssueManager(int ID){
        return mapper.readIssue(ID);
    }


    //SortOrder : if null - desc, createdAt, status
    public List<IssueDB> readIssueListManager(int projectIDFK, String reporter, String assignee, Integer status, String sortOrder){
        return mapper.readIssueList(projectIDFK, reporter, assignee, status, sortOrder);
    }

    public void updateIssueManager(int ID, String title, String description, String reporter, String assignee, String fixer, Integer type, Integer priority, Integer status){
        mapper.updateIssue(ID, title, description, reporter, assignee, fixer, type, priority, status);
    }
    
    public void deleteIssueManager(int ID){
        mapper.deleteIssue(ID);
    }
}
