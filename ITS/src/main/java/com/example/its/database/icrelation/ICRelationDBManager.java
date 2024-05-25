package com.example.its.database.icrelation;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.ICRelationDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ICRelationDBManager {
    private final ICRelationDBMapper mapper;

    public Integer createICRelationManager(int issueID, int commentID){
        ICRelationDB icrelation = new ICRelationDB(issueID, commentID);
        return mapper.createICRelation(icrelation);
    }
    
}
