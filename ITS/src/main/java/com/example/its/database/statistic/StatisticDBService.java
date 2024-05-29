package com.example.its.database.statistic;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticDBService {
    private final StatisticDBManager manager;
    
    public List<Pair<ProjectID, Integer>> countAllofUploadIssueService(List<ProjectID> projectIDList, Timestamp startTime, Timestamp endTime){
        List<Pair<ProjectID, Integer>> result = new ArrayList<>();
        if(projectIDList == null || projectIDList.isEmpty()){return result;}
        
        List<Integer> projects = new ArrayList<>();
        for(ProjectID project :projectIDList){
            projects.add(project.getID());
        }

        List<Integer> processedID = new ArrayList<>();
        List<Map<String, Object>> idbList = manager.countAllofUploadIssueManager(projects, startTime, endTime);

        for (Map<String, Object> idb : idbList){
            int tempID = (int) idb.get("projectID");
            processedID.add(tempID);
            long openCount = (long) idb.get("issueCount");
            int tempCount =(int) openCount;
            Pair<ProjectID, Integer> temp = Pair.of(new ProjectID(tempID), tempCount);
            result.add(temp);
        }
        
        for (ProjectID i : projectIDList){
            if (!processedID.contains(i.getID())){
                Pair<ProjectID, Integer> temp = Pair.of(i, 0);
                result.add(temp);
            }
        }
        return result;
    }
    

    public List<Pair<Issue.TypeID, Integer>> countAllTypeIssueService(ProjectID projectIDFK, Timestamp startTime, Timestamp endTime){
        List<Pair<Issue.TypeID, Integer>> result = new ArrayList<>();
        List<Map<String, Object>> idbList = manager.countAllTypeIssueManager(projectIDFK.getID(), startTime, endTime);
        
        List<Integer> processedType = new ArrayList<>();
        for (Map<String, Object> idb : idbList){
            int intType = (int) idb.get("type");
            processedType.add(intType);
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
            long openCount = (long) idb.get("count");
            int tempCount =(int) openCount;
            Pair<Issue.TypeID, Integer> temp = Pair.of(tempType, tempCount);
            result.add(temp);
        }

        for (int i=0; i<5; i++){
            if (!processedType.contains(i)){
                Issue.TypeID tempType = Issue.TypeID.BUG;
                switch (i) {
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
                Pair<Issue.TypeID, Integer> temp = Pair.of(tempType, 0);
                result.add(temp);
            }
        }
        return result;
    }

    public List<Pair<UserID, Integer>> countIssuesByAssigneeService(ProjectID projectIDFK, Integer type, Integer status){
        List<Pair<UserID, Integer>> result = new ArrayList<>();
        List<Map<String, Object>> idbList = manager.countIssuesByAssigneeManager(projectIDFK.getID(), type, status);

        for (Map<String, Object> idb : idbList){
            String s = (String) idb.get("assignee");
            UserID tempAssignee = new UserID(s);
            long openCount = (long) idb.get("count");
            int tempCount =(int) openCount;
            Pair<UserID, Integer> temp = Pair.of(tempAssignee, tempCount);
            result.add(temp);
        }

        return result;
    }

    public List<Pair<Integer, Integer>> count3MostCommentinIssueService(ProjectID projectIDFK){
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        List<Map<String, Object>> idbList = manager.count3MostCommentinIssueManager(projectIDFK.getID());

        for (Map<String, Object> idb : idbList){
            int tempIssueID = (int) idb.get("issueID");
            long openCount = (long) idb.get("count");
            int tempCount =(int) openCount;
            Pair<Integer, Integer> temp = Pair.of(tempIssueID, tempCount);
            result.add(temp);
        }

        return result;
    }

    public List<Pair<Issue.TypeID, BigDecimal>> countAvgofCommentService(ProjectID projectIDFK){
        List<Pair<Issue.TypeID, BigDecimal>> result = new ArrayList<>();
        List<Map<String, Object>> idbList = manager.countAvgofCommentManager(projectIDFK.getID());
        
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
            BigDecimal tempAvgCount = (BigDecimal) idb.get("avgCount");
            Pair<Issue.TypeID, BigDecimal> temp = Pair.of(tempType, tempAvgCount);
            result.add(temp);
        }

        return result;
    }


}
