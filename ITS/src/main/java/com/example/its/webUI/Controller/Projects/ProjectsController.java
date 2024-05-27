package com.example.its.webUI.Controller.Projects;

import com.example.its.status.StatusManager;
import com.example.its.webUI.Controller.MainController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.its.dataClass.UserID;
import com.example.its.logic.ProjectService;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Controller
@RequiredArgsConstructor
public class ProjectsController {


    private final ProjectService service;

    @Setter
    private UserID ID ;

    //TODO update to production function
    private UserID user(){
        return StatusManager.getInstance().getUser().getID();
//        return new UserID("test1");
    }

    @GetMapping("/projects")
    public String readProjects(Model model) {
        if(MainController.isUserLogin()== null){
            return "redirect:/";
        }
        // Add projects to the model
        model.addAttribute("projects", service.readProjects(user()));
        model.addAttribute("adminProjects", service.readAdminProjects(user()));
        // Return the name of the view (Thymeleaf template)
        return "projects";
    }

    @GetMapping("/projects/create")
    public String createProject() {
        if(MainController.isUserLogin()== null){
            return "redirect:/";
        }
        return "create_project";
    }
}
