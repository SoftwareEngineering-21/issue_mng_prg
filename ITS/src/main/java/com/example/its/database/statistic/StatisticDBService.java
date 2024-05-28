package com.example.its.database.statistic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.ProjectID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticDBService {
    private final StatisticDBManager manager;
    
    public List<Pair<ProjectID, Integer>> readAllofUploadIssueService(List<ProjectID> projectIDList, Timestamp startTime, Timestamp endTime){
        List<Pair<ProjectID, Integer>> result = new ArrayList<>();
        if(projectIDList == null || projectIDList.isEmpty()){return result;}
        
        List<Integer> projects = new ArrayList<>();
        for(ProjectID project :projectIDList){
            projects.add(project.getID());
        }

        List<Integer> processedID = new ArrayList<>();
        List<Map<String, Object>> idbList = manager.readAllofUploadIssueManager(projects, startTime, endTime);

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
    
}
