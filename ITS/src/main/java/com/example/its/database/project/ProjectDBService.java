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

    public void createProjectService(ProjectDB project){
        projectDB.createProject(project);
    }

    public ProjectDB readProjectService(int id){
        return projectDB.readProject(id);
    }

    public List<ProjectDB> readProjectListService(String adminId){
        return projectDB.readProjectList(adminId);
    }

    public void updateProjectService(int id, ProjectDB project){
        projectDB.updateProject(id ,project);
    }

    public void deleteProjectService(int id){
        projectDB.deleteProject(id);
    }
    
}