package com.example.its;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import com.example.its.swingUI.TestController;

//@EnableAsync
@SpringBootApplication
public class ItsApplication implements CommandLineRunner {

    public static void main(String[] args) {

        //헤드리스 모드 끄는 함수. 기본 설정//
        System.setProperty("java.awt.headless", "false");
        //기본 configuration 종료//

        ConfigurableApplicationContext context = SpringApplication.run(ItsApplication.class, args);
        TestController controller = context.getBean(TestController.class);
        //controller.run();
    }

    //public TestController controller;

    @Autowired
    DBService serviceDB;

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("run start");
//        serviceDB.deleteProjectService(new ProjectID(17));
//        serviceDB.deleteUserSerivce(new UserID("qwert"));
//        serviceDB.createUser("qwer", "aa");
//        serviceDB.createProject("alalala", "sdfsfsdf", new UserID("abcd"));
//        List<Project> a = serviceDB.readProjectList(new UserID("abcd"));
//        System.out.println(a.size());
//        System.out.println("run end");
    }

    
}
