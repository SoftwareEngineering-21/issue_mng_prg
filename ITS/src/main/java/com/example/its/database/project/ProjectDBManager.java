package com.example.its.database.project;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.ProjectDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDBManager {
    private final ProjectDBMapper mapper;

    public Integer createProjectManager(String title, String description, String adminID){
        ProjectDB project = new ProjectDB(title, description, adminID);
        mapper.createProject(project);
        return project.getID();
    }

    public ProjectDB readProjectManager(int ID){
        return mapper.readProject(ID);
    }

    public List<ProjectDB> readProjectListManager(String userID){
        return mapper.readProjectList(userID);
    }
    public List<ProjectDB> readAdminProjectListManager(String userID){
        return mapper.readAdminProjectList(userID);
    }


    public void updateProjectManager(int ID, String title, String description){
        ProjectDB preProject = readProjectManager(ID);
        // 빈 값이면 기존값 대입
        if (title.equals("")){
            title = preProject.getTitle();
        }
        if (description.equals("")){
            description = preProject.getDescription();
        }
        ProjectDB new_project = new ProjectDB(title, description, preProject.getAdminID());
        mapper.updateProject(ID ,new_project);
    }

    public void deleteProjectManager(int ID){
        mapper.deleteProject(ID);
    }
    
}