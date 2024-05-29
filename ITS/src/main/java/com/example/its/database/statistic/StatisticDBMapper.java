package com.example.its.database.statistic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StatisticDBMapper {
    List<Map<String, Object>> readAllofUploadIssue(@Param("projectIDList") List<Integer> projectIDList, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
    List<Map<String, Object>> readAllTypeIssue(@Param("projectIDFK") int projectIDFK, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
    
}
