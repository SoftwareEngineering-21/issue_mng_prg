package com.example.its.webUI.Controller.Projects;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.logic.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class CreateProjectController {

    private UserID ID = new UserID("test");


    private final ProjectService projectService;

    @PostMapping("/create")
    public String createProject(@RequestParam("title")String title, @RequestParam("description") String description) {
        projectService.createProject(ID,title,description);
        return "redirect:/projects";
    }

}
