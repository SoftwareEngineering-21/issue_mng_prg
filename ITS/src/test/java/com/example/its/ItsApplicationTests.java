package com.example.its;



import com.example.its.dataClass.Project;
import com.example.its.dataClass.User;
import com.example.its.database.project.ProjectDBService;
import com.example.its.webUI.Controller.Projects.ProjectsController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectsControllerTest {

    @Autowired
    private ItsApplication itsApplication;

    @Autowired
    private ProjectDBService service;

    @Mock
    private Model model;

    @Autowired
    private ProjectsController projectsController;

    @Captor
    private ArgumentCaptor<List<Project>> projectListCaptor;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        User userMock = mock(User.class);
        when(userMock.getID()).thenReturn("test");
        projectsController.setUser(userMock);
        // user 객체를 임의로 초기화

    }

    @Test
    void readProjects() {
        // Controller 메서드 호출
        String viewName = projectsController.readProjects(model);
        // 검증
        //verify(model).addAttribute(eq("projects"), any());

//        verify(model).addAttribute("projects", new ArrayList<>());
//        assertEquals("projects", viewName);
//        assertEquals(14 , capturedProjects.size());

    }
}
