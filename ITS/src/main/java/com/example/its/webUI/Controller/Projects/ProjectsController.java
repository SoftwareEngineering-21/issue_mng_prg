package com.example.its.webUI.Controller.Projects;

import com.example.its.status.StatusManager;
import com.example.its.webUI.Controller.Exception.LoginRequiredException;
import com.example.its.webUI.Controller.MainController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.its.dataClass.UserID;
import com.example.its.logic.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProjectsController{


    private final ProjectService service;
    private final StatusManager statusManager;

    private UserID user(){
        return statusManager.getUser();
    }

    @GetMapping("/projects")
    public String readProjects(Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        // Add projects to the model
        model.addAttribute("projects", service.readProjects(user()));
        model.addAttribute("adminProjects", service.readAdminProjects(user()));
        // Return the name of the view (Thymeleaf template)
        return "projects";
    }

    @GetMapping("/projects/create")
    public String createProject() throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        return "create_project";
    }
}
