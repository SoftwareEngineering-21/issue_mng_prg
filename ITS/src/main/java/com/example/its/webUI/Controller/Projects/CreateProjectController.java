package com.example.its.webUI.Controller.Projects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/projects")
public class CreateProjectController {

    @PostMapping("/create")
    @ResponseBody
    public String createProject(@RequestParam("title")String title, @RequestParam("description") String description) {

        return title+"and"+description;
    }

}
