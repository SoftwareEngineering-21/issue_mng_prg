package com.example.its.webUI.Controller.Projects;

import com.example.its.webUI.Controller.Project;
import com.example.its.webUI.Controller.ProjectID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectsController {
    List<Project> projects = new ArrayList<>() {{
        add(new Project(new ProjectID(1), "project 1", "description for project1"));
        add(new Project(new ProjectID(1), "project 2", "description for project2"));
        add(new Project(new ProjectID(1), "project 3", "description for project3"));
        add(new Project(new ProjectID(1), "project 4", "description for project4"));
        add(new Project(new ProjectID(1), "project 1", "description for project1"));
        add(new Project(new ProjectID(1), "project 2", "description for project2"));
        add(new Project(new ProjectID(1), "project 3", "description for project3"));
        add(new Project(new ProjectID(1), "project 4", "description for project4"));
        add(new Project(new ProjectID(1), "project 1", "description for project1"));
        add(new Project(new ProjectID(1), "project 2", "description for project2"));
        add(new Project(new ProjectID(1), "project 3", "description for project3"));
        add(new Project(new ProjectID(1), "project 4", "description for project4"));
    }};

            @GetMapping("/projects")
            public String readProjects(Model model) {
                // Sample data

                // Add projects to the model
                model.addAttribute("projects", projects);


                // Return the name of the view (Thymeleaf template)
        return "projects";
    }

    @GetMapping("/projects/create")
    public String createProject() {
        return"createProject";
    }
}
