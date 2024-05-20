package com.example.its.webUI.Controller.Projects;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.project.ProjectDBService;
import com.example.its.logic.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProjectsController {


    private final ProjectService service;

    @Setter
    private UserID ID = new UserID("test");

    @GetMapping("/projects")
    public String readProjects(Model model) {
        // Add projects to the model
        model.addAttribute("projects", service.readProjects(ID));
        // Return the name of the view (Thymeleaf template)
        return "projects";
    }

    @GetMapping("/projects/create")
    public String createProject() {
        return "create_project";
    }
}
