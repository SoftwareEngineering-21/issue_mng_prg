package com.example.its.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.project.ProjectDBService;
import com.example.its.database.user.UserDBService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {
    //@Autowired
    private final ProjectDBService projectDBService;
    //@Autowired
    private final UserDBService userDBService;

    //ProjectDB methods
    public ProjectID createProject(String title, String description, UserID adminID){
        return projectDBService.createProjectService(title, description, adminID);
    }

    public Project readProject(ProjectID projectID){
        return projectDBService.readProjectService(projectID);
    }

    public List<Project> readProjectList(UserID adminID){
        return projectDBService.readProjectListService(adminID);
    }

    public void updateProject(ProjectID projectID, String title, String description){
        projectDBService.updateProjectService(projectID, title, description);
    }
    
    public void deleteProjectService(ProjectID projectID){
        projectDBService.deleteProjectService(projectID);
    }


    //UserDB methods
    public Boolean checkRightPW(UserID userID, String inputPW){
        return userDBService.checkRightPWService(userID, inputPW);
    }

    public UserID createUser(String ID, String password){
        return userDBService.createUserService(ID, password);
    }

    public User readUserService(UserID user){
        return userDBService.readUserService(user);
    }

    public void updateUserService(UserID userID, String password, String newPW){
        userDBService.updateUserService(userID, password, newPW);
    }

    public void deleteUserSerivce(UserID userID){
        userDBService.deleteUserSerivce(userID);
    }
}
