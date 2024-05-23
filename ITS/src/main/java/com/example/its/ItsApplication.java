package com.example.its;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.its.database.DBService;
import com.example.its.database.comment.CommentDBManager;
import com.example.its.database.icrelation.ICRelationDBManager;
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
        controller.run();
    }

    //public TestController controller;

    @Autowired
    DBService serviceDB;
    @Autowired
    CommentDBManager manager;
    @Autowired
    ICRelationDBManager imanager;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("run start");
        System.out.println("run end");
    }

    
}
