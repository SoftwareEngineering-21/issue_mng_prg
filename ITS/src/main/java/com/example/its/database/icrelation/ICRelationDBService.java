package com.example.its.database.icrelation;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.CommentID;
import com.example.its.dataClass.IssueID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ICRelationDBService {
    private final ICRelationDBManager manager;

    public Integer createICRelationService(IssueID issueID, CommentID commentID){
        return manager.createICRelationManager(issueID.getID(), commentID.getID());
    }
}
