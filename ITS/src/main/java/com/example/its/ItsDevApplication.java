package com.example.its;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.project.ProjectDBService;
import com.example.its.database.user.UserDBService;
import com.example.its.swingUI.RealLoginContr;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@SpringBootApplication
@ActiveProfiles("test")
@RequiredArgsConstructor
public class ItsDevApplication implements CommandLineRunner {

    private final DataSource dataSource;
    private final ProjectDBService service;
    private final UserDBService userService;


    public static void main(String[] args) {
        SpringApplication.run(ItsDevApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(ItsApplication.class, args);
        RealLoginContr controller = context.getBean(RealLoginContr.class);

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
