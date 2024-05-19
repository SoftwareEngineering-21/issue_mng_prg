package com.example.its.webUI.Controller.Projects;

import com.example.its.dataClass.User;
import com.example.its.logic.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projects")
public class CreateProjectController {

    User user = new User("test");

    @Autowired
    ProjectService projectService;

    @PostMapping("/create")
    @ResponseBody
    public String createProject(@RequestParam("title")String title, @RequestParam("description") String description) {
        projectService.createProject(user,title,description);
        return title+"and"+description;
    }

}
