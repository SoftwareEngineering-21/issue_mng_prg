package com.example.its.database.project;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.ProjectDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDBManager {
    private final ProjectDBMapper projectDB;

    public Integer createProjectManage(String title, String description, String adminID){
        ProjectDB project = new ProjectDB(title, description, adminID);
        projectDB.createProject(project);
        return project.getID();
    }

    public ProjectDB readProjectManage(int ID){
        return projectDB.readProject(ID);
    }

    public List<ProjectDB> readProjectListManage(String adminID){
        return projectDB.readProjectList(adminID);
    }


    public void updateProjectManage(int ID, String title, String description){
        ProjectDB preProject = readProjectManage(ID);
        // 빈 값이면 기존값 대입
        if (title.equals("")){
            title = preProject.getTitle();
        }
        if (description.equals("")){
            description = preProject.getDescription();
        }
        ProjectDB new_project = new ProjectDB(title, description, preProject.getAdminID());
        projectDB.updateProject(ID ,new_project);
    }

    public void deleteProjectManage(int ID){
        projectDB.deleteProject(ID);
    }
    
}