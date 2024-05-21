package com.example.its.database.project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.its.dataClassDB.ProjectDB;

@Mapper
public interface ProjectDBMapper {
    //void createProjectDetailDBTable();
    Integer createProject(ProjectDB project);
    ProjectDB readProject(int ID);
    List<ProjectDB> readProjectList(String adminID);
    void updateProject(@Param("ID") int ID, @Param("project") ProjectDB project);
    void deleteProject(int ID);
    
}