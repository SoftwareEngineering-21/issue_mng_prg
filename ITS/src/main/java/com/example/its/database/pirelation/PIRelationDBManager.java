package com.example.its.database.pirelation;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.PIRelationDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PIRelationDBManager {
    private final PIRelationDBMapper mapper;
    public Integer createPIRelationManager(int projectIDFK, int issueIDFK){
        PIRelationDB pIRelation = new PIRelationDB(projectIDFK, issueIDFK);
        return mapper.createPIRelation(pIRelation);
    }

}
