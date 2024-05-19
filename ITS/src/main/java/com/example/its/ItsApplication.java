package com.example.its;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.its.dataClass.Project;
import com.example.its.database.project.ProjectDBService;
import com.example.its.swingUI.TestController;

@EnableAsync
@SpringBootApplication
public class ItsApplication implements CommandLineRunner {

    public static void main(String[] args) {

        //헤드리스 모드 끄는 함수. 기본 설정//
        System.setProperty("java.awt.headless", "false");
        //기본 configuration 종료//

        SpringApplication.run(ItsApplication.class, args);
    }

    public TestController controller;

    @Autowired
    public ProjectDBService service;
    
    @Override
    public void run(String... args) throws Exception {


        List<Project> pr = service.readProjectListService("test");
        System.out.println(pr.size());
        for(Project p : pr) {
            System.out.println(p.getAdmin().getUserID()+"," + p.getID().getID() +","+ p.getTitle()+","+p.getDescription());
        }


        controller = new TestController();
    }
}
