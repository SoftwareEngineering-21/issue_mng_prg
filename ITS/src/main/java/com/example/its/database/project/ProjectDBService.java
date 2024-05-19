package com.example.its.database.project;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClassDB.ProjectDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ProjectDBService {

    @Autowired
    private ProjectDBManager manager;

    public List<Project> readProjectListService(User adminID){
        CompletableFuture<List<ProjectDB>> rs = manager.readProjectListServiceDB(adminID.getID());
        try {
            List<ProjectDB> list = rs.get();
            List<Project> projects = new ArrayList<>();
            for (ProjectDB projectDB : list) {
                projects.add(new Project(new ProjectID(projectDB.getId()),projectDB.getTitle(),projectDB.getDescription(),new User(projectDB.getAdminID())));

            }
            return projects;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
    public void createProjectService(String title, String description, User adminID){
        manager.createProjectManage(title, description, adminID.getID());
    }
}
