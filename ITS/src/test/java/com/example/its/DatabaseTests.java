package com.example.its;


import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.project.ProjectDBService;
import com.example.its.logic.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("dev")
public class DatabaseTests {
    @Autowired
    DatabaseTests(ProjectService projectService){
        this.projectService = projectService;
    }

    @Autowired
    private ProjectService projectService;

    UserID user;

    @BeforeEach
    void serUp(){
        user = new UserID("test2");
    }

    @Test
    public void readProjectList(){
        List<Project> list = projectService.readAdminProjects(user);
        System.out.println(list.size());
        Assertions.assertEquals(list.get(0).getProjectID().getID(), 2);
        // 테스트 내용 예시 : result == ArrayList<Project>{test,test2} 라면 통과, 아니라면 fail
    }
}
