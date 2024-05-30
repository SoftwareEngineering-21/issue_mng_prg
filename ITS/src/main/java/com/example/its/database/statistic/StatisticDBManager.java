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
    public List<Map<String, Object>> countAllofUploadIssueManager(List<Integer> projectIDList, Timestamp startTime, Timestamp endTime){
        return mapper.countAllofUploadIssue(projectIDList, startTime, endTime);
    }

    public List<Map<String, Object>> countAllTypeIssueManager(int projectIDFK, Timestamp startTime,Timestamp endTime){
        return mapper.countAllTypeIssue(projectIDFK, startTime, endTime);
    }

    public List<Map<String, Object>> countIssuesByAssigneeManager(int projectIDFK, Integer type, Integer status){
        return mapper.countIssuesByAssignee(projectIDFK, type, status);
    }

    public List<Map<String, Object>> count3MostCommentinIssueManager(int projectIDFK){
        return mapper.count3MostCommentinIssue(projectIDFK);
    }

    public List<Map<String, Object>> countAvgofCommentManager(int projectIDFK){
        return mapper.countAvgofComment(projectIDFK);
    }
    
}
