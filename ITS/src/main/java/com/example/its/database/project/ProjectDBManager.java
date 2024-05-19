package com.example.its.database.project;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.scheduling.annotation.Async;

import com.example.its.dataClassDB.ProjectDB;

//import jakarta.anotation.PostConstruct;
import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class ProjectDBManager {
    private final ProjectDBMapper projectDB;

    @Async
    public void createProjectManage(String title, String description, String adminID){
        synchronized (this) {
            ProjectDB project = new ProjectDB(title, description, adminID);
            projectDB.createProject(project);
        }
    }

    //TODO int id 말고 UserID id 같은 객체로 parameter 바꿀것
    @Async
    public CompletableFuture<ProjectDB> readProjectManage(int ID){
        synchronized (this){
            return CompletableFuture.completedFuture(projectDB.readProject(ID));
        }
    }

    @Async
    public CompletableFuture<List<ProjectDB>> readProjectListManage(String adminID){
        synchronized (this){
            return CompletableFuture.completedFuture(projectDB.readProjectList(adminID));
        }
    }




    @Async
    public void updateProjectManage(int ID, String title, String description){
        ProjectDB preProject;
        synchronized (this) {
            try {
                preProject = readProjectManage(ID).get();
                // 빈 값이면 기존값 대입
                if (title.equals("")){
                    title = preProject.getTitle();
                }
                if (description.equals("")){
                    description = preProject.getDescription();
                }
                ProjectDB new_project = new ProjectDB(title, description, preProject.getAdminID());
                projectDB.updateProject(ID ,new_project);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Async
    public void deleteProjectManage(int ID){
        synchronized (this) {
            projectDB.deleteProject(ID);
        }
    }
    
}