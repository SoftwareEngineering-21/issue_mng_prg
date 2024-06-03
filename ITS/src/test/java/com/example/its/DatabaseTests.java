 package com.example.its;


 import com.example.its.dataClass.Project;
 import com.example.its.dataClass.User;
 import com.example.its.dataClass.UserID;
 import com.example.its.database.project.ProjectDBService;
 import com.example.its.logic.ProjectService;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import org.mockito.Mock;
 import org.mockito.MockitoAnnotations;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.test.context.ActiveProfiles;

 import java.util.List;

 import static org.mockito.Mockito.when;

 @SpringBootTest
 @SpringBootApplication
 @ActiveProfiles("test")
 public class DatabaseTests {

     @Autowired
     private ProjectDBService service;

     @Autowired
     private ProjectService projectService;


     UserID user;


     @BeforeEach
     void serUp(){

        user = new UserID("test1");




     }


     @Test
     void readProjectList(){
         List<Project> result = projectService.readProjects(user);

         for(Project p : result){
             System.out.println(p.getTitle());
         }


     }


 }
