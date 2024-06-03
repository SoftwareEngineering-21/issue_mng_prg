package com.example.its.logic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;
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

    public List<String> getProjectList(UserID userID){
        List<Project> list = service.readProjectList(userID);
        list.addAll(service.readAdminProjectList(userID));

        List<String> result = new ArrayList<>();
        for(Project p : list){
            result.add(p.getTitle());
        }
        return result;
    }


    public Map<String, Object> count3MostCommentinIssueService(ProjectID projectIDFK){
        return service.count3MostCommentinIssue(projectIDFK);
    }

    public List<Map<String, Object>> count3MostCommentinIssueService(UserID userID){
        List<Project> list = service.readProjectList(userID);
        list.addAll(service.readAdminProjectList(userID));
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        for(Project p : list){
            result.add(count3MostCommentinIssueService(p.getProjectID()));
        }
        return result;
    }

    public Map<String, Object> countAvgofCommentService(ProjectID projectIDFK){
        return service.countAvgofComment(projectIDFK);
    }

    public List<Map<String,Object>> countAvgofCommentService(UserID userID){
        List<Project> list = service.readProjectList(userID);
        list.addAll(service.readAdminProjectList(userID));
        List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
        for(Project p : list){
            result.add(countAvgofCommentService(p.getProjectID()));
        }
        return result;
    }

    public List<Integer> issuePerProject(UserID userID){
        List<Integer> list = new ArrayList<>();
        List<Project> plist = service.readProjectList(userID);
        plist.addAll(service.readAdminProjectList(userID));
        for(Project p : plist){
            List<Issue> issues = service.readIssueList(p.getProjectID(),null,null,null,null);
            list.add(issues.size());
        }
        return list;
    }

}
