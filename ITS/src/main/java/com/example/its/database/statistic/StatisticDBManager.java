package com.example.its.database.statistic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticDBManager {
    private final StatisticDBMapper mapper;
    public List<Map<String, Object>> readAllofUploadIssueManager(List<Integer> projectIDList, Timestamp startTime, Timestamp endTime){
        return mapper.readAllofUploadIssue(projectIDList, startTime, endTime);
    }

    public List<Map<String, Object>> readAllTypeIssueManager(int projectIDFK, Timestamp startTime,Timestamp endTime){
        return mapper.readAllTypeIssue(projectIDFK, startTime, endTime);
    }
    
}
