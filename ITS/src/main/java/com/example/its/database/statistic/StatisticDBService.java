package com.example.its.database.statistic;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.Project;
import com.example.its.database.issue.IssueDBService;
import com.example.its.database.project.ProjectDBService;
import com.example.its.logic.IssueService;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.ProjectID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticDBService {
    private final StatisticDBManager manager;
    private final ProjectDBService projectDBService;
    private final IssueDBService issueDBService;

    public Map<String, Object> countAllofUploadIssueService(List<ProjectID> projectIDList, Timestamp startTime, Timestamp endTime){
        Map<String, Object> result = new HashMap<>();

        if(projectIDList == null || projectIDList.isEmpty()){
            result.put("labels", new ArrayList<>());
            result.put("data", new ArrayList<>());
            return result;
        }

        List<Integer> projects = new ArrayList<>();
        for(ProjectID project :projectIDList){
            projects.add(project.getID());
        }
        
        List<Map<String, Object>> idbList = manager.countAllofUploadIssueManager(projects, startTime, endTime);
        List<Integer> intLabels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();


        for (Map<String, Object> idb : idbList){
            int tempID = (int) idb.get("projectID");
            intLabels.add(tempID);

            long openCount = (long) idb.get("issueCount");
            int tempCount =(int) openCount;
            data.add(tempCount);
        }
        
        for (ProjectID i : projectIDList){
            if (!intLabels.contains(i.getID())){
                intLabels.add(i.getID());
                data.add(0);
            }
        }

        List<String> labels = new ArrayList<>();
        for (Integer label : intLabels) {
            Project proj = projectDBService.readProjectService(new ProjectID(label));
            labels.add(proj.getTitle());

        }

        //가독성을 위해 5개까지만 제공
        if(data.size()>5 && labels.size()>5){
            data = data.stream().limit(5).collect(Collectors.toList());
            labels = labels.stream().limit(5).collect(Collectors.toList());
        }
        result.put("data", data);
        result.put("labels", labels);
        return result;
    }
    

    public Map<String, Object> countAllTypeIssueService(ProjectID projectIDFK, Timestamp startTime, Timestamp endTime){
        Map<String, Object> result = new HashMap<>();
        
        List<Map<String, Object>> idbList = manager.countAllTypeIssueManager(projectIDFK.getID(), startTime, endTime);
        List<Issue.TypeID> typeLabels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for (Map<String, Object> idb : idbList){
            int intType = (int) idb.get("type");
            Issue.TypeID tempType = Issue.TypeID.BUG;
            switch (intType) {
                case 0:
                    tempType = Issue.TypeID.BUG;
                    break;
                case 1:
                    tempType = Issue.TypeID.IMPROVEMENT;
                    break;
                case 2:
                    tempType = Issue.TypeID.NEW_FEATURE;
                    break;
                case 3:
                    tempType = Issue.TypeID.TASK;
                    break;
                case 4:
                    tempType = Issue.TypeID.STORY;
                    break;
            }
            typeLabels.add(tempType);

            long openCount = (long) idb.get("count");
            int tempCount =(int) openCount;
            data.add(tempCount);
        }


        if(!typeLabels.contains(Issue.TypeID.BUG)){
            typeLabels.add(Issue.TypeID.BUG);
            data.add(0);
        }
        if(!typeLabels.contains(Issue.TypeID.IMPROVEMENT)){
            typeLabels.add(Issue.TypeID.IMPROVEMENT);
            data.add(0);
        }
        if(!typeLabels.contains(Issue.TypeID.NEW_FEATURE)){
            typeLabels.add(Issue.TypeID.NEW_FEATURE);
            data.add(0);
        }
        if(!typeLabels.contains(Issue.TypeID.TASK)){
            typeLabels.add(Issue.TypeID.TASK);
            data.add(0);
        }
        if(!typeLabels.contains(Issue.TypeID.STORY)){
            typeLabels.add(Issue.TypeID.STORY);
            data.add(0);
        }
        


        List<String> labels = new ArrayList<>();
        for (Issue.TypeID label : typeLabels) {
            labels.add(label.name());
        }

        result.put("data", data);
        result.put("labels", labels);
        return result;
    }


    public  Map<String, Object> countIssuesByAssigneeService(ProjectID projectIDFK, Integer type, Integer status){
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> idbList = manager.countIssuesByAssigneeManager(projectIDFK.getID(), type, status);
        if(idbList.size()==0){
            result.put("labels", new ArrayList<>());
            result.put("data", new ArrayList<>());
            return result;
        }

        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for (Map<String, Object> idb : idbList){
            String tempAssignee = (String) idb.get("assignee");
            labels.add(tempAssignee);

            long openCount = (long) idb.get("count");
            int tempCount =(int) openCount;
            data.add(tempCount);
        }

        //가독성을 위해 5개까지만 제공
        if(data.size()>5 && labels.size()>5){
            data = data.stream().limit(5).collect(Collectors.toList());
            labels = labels.stream().limit(5).collect(Collectors.toList());
        }
        result.put("data", data);
        result.put("labels", labels);
        return result;
    }


    public Map<String, Object> count3MostCommentinIssueService(ProjectID projectIDFK){
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> idbList = manager.count3MostCommentinIssueManager(projectIDFK.getID());

        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for (Map<String, Object> idb : idbList){
            int tempIssueID = (int) idb.get("issueID");
            Issue issue = issueDBService.readIssueService(new IssueID(tempIssueID));
            labels.add(String.valueOf(issue.getTitle()));

            long openCount = (long) idb.get("count");
            int tempCount =(int) openCount;
            data.add(tempCount);
        }

        result.put("data", data);
        result.put("labels", labels);
        return result;
    }

    public Map<String, Object> countAvgofCommentService(ProjectID projectIDFK){
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> idbList = manager.countAvgofCommentManager(projectIDFK.getID());
        
        List<Issue.TypeID> typeLabels = new ArrayList<>();
        List<BigDecimal> data = new ArrayList<>();

        for (Map<String, Object> idb : idbList){
            int intType = (int) idb.get("type");
            Issue.TypeID tempType = Issue.TypeID.BUG;
            switch (intType) {
                case 0:
                    tempType = Issue.TypeID.BUG;
                    break;
                case 1:
                    tempType = Issue.TypeID.IMPROVEMENT;
                    break;
                case 2:
                    tempType = Issue.TypeID.NEW_FEATURE;
                    break;
                case 3:
                    tempType = Issue.TypeID.TASK;
                    break;
                case 4:
                    tempType = Issue.TypeID.STORY;
                    break;
            }
            typeLabels.add(tempType);

            BigDecimal tempAvgCount = (BigDecimal) idb.get("avgCount");
            data.add(tempAvgCount);
        }


        if(!typeLabels.contains(Issue.TypeID.BUG)){
            typeLabels.add(Issue.TypeID.BUG);
            data.add(BigDecimal.valueOf(0));
        }
        if(!typeLabels.contains(Issue.TypeID.IMPROVEMENT)){
            typeLabels.add(Issue.TypeID.IMPROVEMENT);
            data.add(BigDecimal.valueOf(0));
        }
        if(!typeLabels.contains(Issue.TypeID.NEW_FEATURE)){
            typeLabels.add(Issue.TypeID.NEW_FEATURE);
            data.add(BigDecimal.valueOf(0));
        }
        if(!typeLabels.contains(Issue.TypeID.TASK)){
            typeLabels.add(Issue.TypeID.TASK);
            data.add(BigDecimal.valueOf(0));
        }
        if(!typeLabels.contains(Issue.TypeID.STORY)){
            typeLabels.add(Issue.TypeID.STORY);
            data.add(BigDecimal.valueOf(0));
        }
        


        List<String> labels = new ArrayList<>();
        for (Issue.TypeID label : typeLabels) {
            labels.add(label.name());
        }

        result.put("data", data);
        result.put("labels", labels);
        return result;
        
    }


}
