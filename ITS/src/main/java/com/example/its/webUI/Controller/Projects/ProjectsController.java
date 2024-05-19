package com.example.its.webUI.Controller.Projects;

import com.example.its.dataClass.User;
import com.example.its.database.project.ProjectDBService;
import com.example.its.webUI.Controller.Project;
import com.example.its.webUI.Controller.ProjectID;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectsController {


    private final ProjectDBService service;

    @Setter
    private User user = new User("test2");

    @GetMapping("/projects")
    public String readProjects(Model model) {
        // Sample data

        // Add projects to the model
        model.addAttribute("projects", service.readProjectListService(user));


        // Return the name of the view (Thymeleaf template)
        return "projects";
    }

    @GetMapping("/projects/create")
    public String createProject() {
        return"createProject";
    }
}
