package com.example.its.webUI.Controller.Projects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects/admin")
public class ProjectAdminController {
    @GetMapping("/projectID={projectId}")
    public String projectAdmin(@PathVariable("projectId") String projectID, Model model) {
        return "project_admin";

    }

}
