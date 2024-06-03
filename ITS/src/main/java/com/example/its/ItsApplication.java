package com.example.its;

import com.example.its.state.StateManager;
import com.example.its.swingUI.TestController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.its.database.DBService;
import com.example.its.swingUI.MainSwingController;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableAsync
@SpringBootApplication
@RequiredArgsConstructor
public class ItsApplication implements CommandLineRunner {

//    @Autowired
//    public static RealLoginContr realLoginContr;
    public static void main(String[] args) {
        //헤드리스 모드 끄는 함수. 기본 설정//
        System.setProperty("java.awt.headless", "false");
        //기본 configuration 종료//

        ConfigurableApplicationContext context = SpringApplication.run(ItsApplication.class, args);
        MainSwingController controller = context.getBean(MainSwingController.class);
        //TestController controller = new TestController(new StateManager());
        controller.run();
    }

    //public TestController controller;

    @Override
    public void run(String... args) throws Exception {

    }

    
}
