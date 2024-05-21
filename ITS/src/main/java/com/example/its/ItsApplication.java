package com.example.its;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.project.ProjectDBService;
import com.example.its.database.user.UserDBService;
import com.example.its.swingUI.TestController;

@EnableAsync
@SpringBootApplication
public class ItsApplication implements CommandLineRunner {

    public static void main(String[] args) {

        //헤드리스 모드 끄는 함수. 기본 설정//
        System.setProperty("java.awt.headless", "false");
        //기본 configuration 종료//

        ConfigurableApplicationContext context = SpringApplication.run(ItsApplication.class, args);
        TestController controller = context.getBean(TestController.class);
        controller.run();
    }

    //public TestController controller;

    @Autowired
    public ProjectDBService projectService;
    @Autowired
    public UserDBService userService;


    
    @Override
    public void run(String... args) throws Exception {

        //pdbs.createProjectService("aaa", "ab", "test");

        //service.createProjectService("t","a",new User("test"));
        // List<Project> pr = service.readProjectListService(new User("test"));
        // System.out.println(pr.size());
        // for(Project p : pr) {
        //     System.out.println(p.getAdmin().getID()+"," + p.getProjectID().getID() +","+ p.getTitle()+","+p.getDescription());
        // }
        System.out.println("run start");
        // UserID a;
        // a = userService.createUserService("newenwew", "abcd");
        // System.out.println(a.getID());
        ProjectID b;
        b = projectService.createProjectService("title", "it is description", new UserID("abcd"));
        System.out.println(b.getID());
        
        System.out.println("run end");


        }

    
}
