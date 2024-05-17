package com.example.its.database.project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.its.dataClassDB.ProjectDB;

@Mapper
public interface ProjectDBMapper {
    //void createProjectDetailDBTable();
    void createProject(ProjectDB project);
    ProjectDB readProject(int id);
    List<ProjectDB> readProjectList(String adminId);
    void updateProject(@Param("id") int id, @Param("project") ProjectDB project);
    void deleteProject(int id);
    
}