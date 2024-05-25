package com.example.its.database.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.dataClassDB.ProjectDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDBService {

    //@Autowired
    private final ProjectDBManager manager;

    //ProjectDB DTO to Project DTO
    private Project PDBtoProject(ProjectDB pdb){
        Project newP = new Project(new ProjectID(pdb.getID()), pdb.getTitle(), pdb.getDescription(), new UserID(pdb.getAdminID()));
        return newP;
    }

    //create Project
    public ProjectID createProjectService(String title, String description, UserID adminID){
        Integer temp = manager.createProjectManager(title, description, adminID.getID());
        ProjectID returnID = new ProjectID(temp);
        return returnID;

    }

    //read one project
    public Project readProjectService(ProjectID projectID){
        ProjectDB rpd = manager.readProjectManager(projectID.getID());
        Project pd = PDBtoProject(rpd);
        return pd;
    }

    //read project List
    public List<Project> readProjectListService(UserID userID){
        List<ProjectDB> rslist = manager.readProjectListManager(userID.getID());
        List<Project> projects = new ArrayList<>();
        for (ProjectDB projectDB : rslist) {
            projects.add(PDBtoProject(projectDB));
        }
        return projects;
    }
    public List<Project> readAdminProjectListService(UserID userID){
        List<ProjectDB> rslist = manager.readAdminProjectListManager(userID.getID());
        List<Project> projects = new ArrayList<>();
        for (ProjectDB projectDB : rslist) {
            projects.add(PDBtoProject(projectDB));
        }
        return projects;
    }
    
    //update projectDB title, description
    public void updateProjectService(ProjectID projectID, String title, String description){
        manager.updateProjectManager(projectID.getID(), title, description);
    }

    // delete projectDB
    public void deleteProjectService(ProjectID projectID){
        manager.deleteProjectManager(projectID.getID());
    }

}
