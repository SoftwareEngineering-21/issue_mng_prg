package com.example.its.database.project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClassDB.ProjectDB;

@Service
public class ProjectDBService {

    @Autowired
    private ProjectDBManager manager;

    public List<Project> readProjectListService(String adminID){
        CompletableFuture<List<ProjectDB>> rs = manager.readProjectListServiceDB(adminID);
        try {
            List<ProjectDB> list = rs.get();
            List<Project> projects = new ArrayList<>();
            for (ProjectDB projectDB : list) {
                projects.add(new Project(new ProjectID(projectDB.getId()),projectDB.getTitle(),projectDB.getDescription(),new User(projectDB.getAdminId())));
                return projects;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException();
    }
}
