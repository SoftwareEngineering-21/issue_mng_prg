package com.example.its.database.pirelation;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PIRelationDBService {
    private final PIRelationDBManager manager;

    public int createPIRelationService(ProjectID projectIDFK, IssueID issueIDFK){
        return manager.createPIRelationManager(projectIDFK.getID(), issueIDFK.getID());
    }
    
}
