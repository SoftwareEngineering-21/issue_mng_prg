package com.example.its.database.issue;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.its.dataClassDB.IssueDB;

@Mapper
public interface IssueDBMapper {
    Integer createIssue(IssueDB issue);
    IssueDB readIssue(int ID);
    List<IssueDB> readIssueList(@Param("projectIDFK") int projectIDFK, @Param("reporter") String reporter,@Param("assignee") String assignee,@Param("status") Integer status,@Param("sortOrder") String sortOrder);
    void updateIssue(@Param("ID") int ID,@Param("title") String title,@Param("description") String description,@Param("reporter") String reporter,@Param("assignee") String assignee,@Param("fixer") String fixer,@Param("type") Integer type,@Param("priority") Integer priority,@Param("status") Integer status);
    void deleteIssue(int ID);
    
}
