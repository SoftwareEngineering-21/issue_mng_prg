package com.example.its.logic;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StatisticService {
    private final DBService service;

    //유저의 프로젝트 통틀어서 입력된 기간동안 이슈 많은 애들 상위 5개
    public Map<String, Object> countAllofUploadIssue(UserID userID, Timestamp startTime, Timestamp endTime){
        return service.countAllofUploadIssue(userID, startTime, endTime);
    }


    public Map<String, Object> countAllTypeIssue(ProjectID projectID, Timestamp startTime, Timestamp endTime){
        return service.countAllTypeIssue(projectID, startTime, endTime);
    }

    public Map<String, Object> countIssuesByAssigneeService(ProjectID projectIDFK, Integer type, Integer status){
        return service.countIssuesByAssignee(projectIDFK, type, status);
    }

    public Map<String, Object> count3MostCommentinIssueService(ProjectID projectIDFK){
        return service.count3MostCommentinIssue(projectIDFK);
    }

    public Map<String, Object> countAvgofCommentService(ProjectID projectIDFK){
        return service.countAvgofComment(projectIDFK);
    }
}
