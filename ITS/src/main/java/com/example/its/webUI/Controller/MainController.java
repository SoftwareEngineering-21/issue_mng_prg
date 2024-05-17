package com.example.its.webUI.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        return "redirect:/test";
    }

    @GetMapping("/demo")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "main";
    }


    @GetMapping("/projects")
    public String readProjects(Model model) {
        // Sample data
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1,"project 1","description for project1"));
        projects.add(new Project(2,"project 2","description for project2"));
        projects.add(new Project(3,"project 3","description for project3"));
        projects.add(new Project(4,"project 4","description for project4"));
        projects.add(new Project(5,"project 1","description for project1"));
        projects.add(new Project(6,"project 2","description for project2"));
        projects.add(new Project(7,"project 3","description for project3"));
        projects.add(new Project(8,"project 4","description for project4"));
        projects.add(new Project(9,"project 1","description for project1"));
        projects.add(new Project(10,"project 2","description for project2"));
        projects.add(new Project(11,"project 3","description for project3"));
        projects.add(new Project(12,"project 4","description for project4"));




        // Add projects to the model
        model.addAttribute("projects", projects);


        // Return the name of the view (Thymeleaf template)
        return "projects";
    }
}

