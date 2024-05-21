package com.example.its.database.project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.dataClassDB.ProjectDB;

@EnableAsync
@Service
public class ProjectDBService {

    @Autowired
    private ProjectDBManager manager;

    //ProjectDB DTO to Project DTO
    private Project PDBtoProject(ProjectDB pdb){
        Project newP = new Project(new ProjectID(pdb.getID()), pdb.getTitle(), pdb.getDescription(), new UserID(pdb.getAdminID()));
        return newP;
    }

    //create Project
    public ProjectID createProjectService(String title, String description, UserID adminID){
        try {
            CompletableFuture<Integer> temp = manager.createProjectManage(title, description, adminID.getID());
            ProjectID returnID = new ProjectID(temp.get());
            return returnID;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    //read one project
    public Project readProjectService(ProjectID projectID){
        CompletableFuture<ProjectDB> pdb = manager.readProjectManage(projectID.getID());
        try {
            ProjectDB rpd = pdb.get();
            Project pd = PDBtoProject(rpd);
            return pd;
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        // TODO 왜인지 throw error가 에러가 남
        //throw new RuntimeException();
    }

    // TODO adminId 말고 권한으로 바꾸기
    //read project List
    public List<Project> readProjectListService(UserID adminID){
        CompletableFuture<List<ProjectDB>> rs = manager.readProjectListManage(adminID.getID());
        try {
            List<ProjectDB> rslist = rs.get();
            List<Project> projects = new ArrayList<>();
            for (ProjectDB projectDB : rslist) {
                projects.add(PDBtoProject(projectDB));
            }
            return projects;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //throw new RuntimeException();
    }
    
    //update projectDB title, description
    public void updateProjectService(ProjectID projectID, String title, String description){
        manager.updateProjectManage(projectID.getID(), title, description);
    }

    // delete projectDB
    public void deleteProjectService(ProjectID projectID){
        manager.deleteProjectManage(projectID.getID());
    }

}
