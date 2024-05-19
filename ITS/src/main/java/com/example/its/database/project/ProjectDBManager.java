package com.example.its.database.project;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.ProjectDB;

//import jakarta.anotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectDBManager {
    private final ProjectDBMapper projectDB;

    @Async
    public void createProjectManage(String title, String description, String adminId){
        synchronized (this) {
            ProjectDB project = new ProjectDB(title, description, adminId);
            projectDB.createProject(project);
        }
    }

    //TODO int id 말고 UserID id 같은 객체로 parameter 바꿀것
    @Async
    public CompletableFuture<ProjectDB> readProjectService(int id){
        synchronized (this){
            return CompletableFuture.completedFuture(projectDB.readProject(id));
        }
    }

    @Async
    public CompletableFuture<List<ProjectDB>> readProjectListServiceDB(String adminId){
        synchronized (this){
            return CompletableFuture.completedFuture(projectDB.readProjectList(adminId));
        }
    }




    @Async
    public void updateProjectService(int id, String title, String description){
        ProjectDB preProject;
        synchronized (this) {
            try {
                preProject = readProjectService(id).get();
                // 빈 값이면 기존값 대입
                if (title.equals("")){
                    title = preProject.getTitle();
                }
                if (description.equals("")){
                    description = preProject.getDescription();
                }
                ProjectDB new_project = new ProjectDB(title, description, preProject.getAdminID());
                projectDB.updateProject(id ,new_project);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        


        synchronized (this) {

        }
    }

    @Async
    public void deleteProjectService(int id){
        synchronized (this) {
            projectDB.deleteProject(id);
        }
    }
    
}