package com.example.its.database.statistic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StatisticDBMapper {
    List<Map<String, Object>> countAllofUploadIssue(@Param("projectIDList") List<Integer> projectIDList, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
    List<Map<String, Object>> countAllTypeIssue(@Param("projectIDFK") int projectIDFK, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
    List<Map<String, Object>> countIssuesByAssignee(@Param("projectIDFK") int projectIDFK, @Param("type") Integer type, @Param("status") Integer status);
    List<Map<String, Object>> count3MostCommentinIssue(@Param("projectIDFK") int projectIDFK);
    List<Map<String, Object>> countAvgofComment(@Param("projectIDFK") int projectIDFK);
}
