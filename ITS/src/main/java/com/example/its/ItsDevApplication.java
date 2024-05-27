package com.example.its;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.test.context.ActiveProfiles;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.project.ProjectDBService;
import com.example.its.database.user.UserDBService;
import com.example.its.swingUI.MainSwingController;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
//@ActiveProfiles("test")
@RequiredArgsConstructor
public class ItsDevApplication implements CommandLineRunner {

    private final DataSource dataSource;
    private final ProjectDBService service;
    private final UserDBService userService;


    public static void main(String[] args) {
        SpringApplication.run(ItsDevApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(ItsApplication.class, args);
        MainSwingController controller = context.getBean(MainSwingController.class);

        controller.run();
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Url: " + connection.getMetaData().getURL());
            System.out.println("UserName: " + connection.getMetaData().getUserName());
        }
        List<Project> p = service.readProjectListService(new UserID("test3"));
        User u =userService.readUserService(new UserID("test4"));
        System.out.println(u);

    }
}
