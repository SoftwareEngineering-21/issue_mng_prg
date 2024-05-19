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

    //ProjectDB DTO to Project DTO
    private Project PDBtoProject(ProjectDB pdb){
        Project newP = new Project(new ProjectID(pdb.getID()), pdb.getTitle(), pdb.getDescription(), new User(pdb.getAdminID()));
        return newP;
    }

    //create Project
    public void createProjectService(String title, String description, User adminID){
        manager.createProjectManage(title, description, adminID.getUserID());
    }

    //read one project
    public Project readProjectService(int ID){
        CompletableFuture<ProjectDB> pdb = manager.readProjectManage(ID);
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
        // TODO 왜인지 밑에랑 다르게 throw error가 에러가 남
        //throw new RuntimeException();
    }

    // TODO adminId 말고 권한으로 바꾸기
    //read project List
    public List<Project> readProjectListService(User adminID){
        CompletableFuture<List<ProjectDB>> rs = manager.readProjectListManage(adminID.getUserID());
        try {
            List<ProjectDB> list = rs.get();
            List<Project> projects = new ArrayList<>();
            for (ProjectDB projectDB : list) {
                projects.add(PDBtoProject(projectDB));
                return projects;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException();
    }
    
    //update projectDB title, description
    public void updateProjectService(int ID, String title, String description){
        manager.updateProjectManage(ID, title, description);
    }

    // delete projectDB
    public void deleteProjectService(int ID){
        manager.deleteProjectManage(ID);
    }

}
