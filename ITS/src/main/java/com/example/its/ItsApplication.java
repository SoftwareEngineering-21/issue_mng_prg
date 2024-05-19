package com.example.its;

import java.util.List;

import com.example.its.database.project.ProjectDBService;
import com.example.its.swingUI.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.its.database.project.ProjectDBManager;
import com.example.its.mybatis.SampleDTO;

@EnableAsync
@SpringBootApplication
public class ItsApplication implements CommandLineRunner {

    public static void main(String[] args) {

        //헤드리스 모드 끄는 함수. 기본 설정//
        System.setProperty("java.awt.headless", "false");
        //기본 configuration 종료//

        SpringApplication.run(ItsApplication.class, args);
    }

    @Autowired
    public ProjectDBManager pdbs;

    @Autowired
    public ProjectDBService service;

    public TestController controller;

    public  List<SampleDTO> sampleDTOList;


    
    @Override
    public void run(String... args) throws Exception {

        pdbs.createProjectService("aaa", "ab", "test");



        controller = new TestController();
    }
}
