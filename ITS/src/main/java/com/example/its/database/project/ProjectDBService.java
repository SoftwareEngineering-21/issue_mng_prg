package com.example.its.database.project;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.ProjectDB;

//import jakarta.anotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDBService {
    private final ProjectDBMapper projectDB;

    // @PostConstruct
    // public void init(){
    //     projectDB.createProjectDetailDBTable();
    // }

    public void createProjectService(String title, String description, String adminId){
        ProjectDB project = new ProjectDB(title, description, adminId);
        projectDB.createProject(project);
    }

    public ProjectDB readProjectService(int id){
        return projectDB.readProject(id);
    }

    public List<ProjectDB> readProjectListService(String adminId){
        return projectDB.readProjectList(adminId);
    }

    public void updateProjectService(int id, String title, String description){
        ProjectDB preProject = readProjectService(id);
        
        // 빈 값이면 기존값 대입
        if (title.equals("")){
            title = preProject.getTitle();
        }
        if (description.equals("")){
            title = preProject.getDescription();
        }

        ProjectDB new_project = new ProjectDB(title, description, preProject.getAdminId());
        projectDB.updateProject(id ,new_project);
    }

    public void deleteProjectService(int id){
        projectDB.deleteProject(id);
    }
    
}