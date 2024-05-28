package com.example.its.webUI.Controller.Projects;

import com.example.its.status.StatusManager;
import com.example.its.webUI.Controller.Exception.LoginException;
import com.example.its.webUI.Controller.MainController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.its.dataClass.UserID;
import com.example.its.logic.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class CreateProjectController {

    private UserID user(){
        return StatusManager.getInstance().getUser();
    }

    private final ProjectService projectService;

    @PostMapping("/create")
    // @ResponseBody
    public String createProject(@RequestParam("title")String title, @RequestParam("description") String description) throws LoginException {
        MainController.isUserLogin();
        projectService.createProject(user(),title,description);
        return "redirect:/projects";
    }

}
