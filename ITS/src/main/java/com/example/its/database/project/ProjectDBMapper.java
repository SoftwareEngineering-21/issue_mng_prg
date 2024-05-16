package com.example.its.database.project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.its.dataClassDB.ProjectDetailDB;

@Mapper
public interface ProjectDBMapper {
    //void createProjectDetailDBTable();
    void createProject(ProjectDetailDB project);
    ProjectDetailDB readProject(int id);
    List<ProjectDetailDB> readProjectList(String adminId);
    void updateProject(@Param("id") int id, @Param("project") ProjectDetailDB project);
    void deleteProject(int id);
    
}