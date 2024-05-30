package com.example.its.webUI.Controller.Issue;


import com.example.its.status.StatusManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class IssuesController {

    @GetMapping("/projectid={projectID}")
    public String issues(@PathVariable("projectID") int projectID, Model model) {
        //현재 접근중인 projectID

        model.addAttribute("projectID", projectID);

        return "issues";
    }

}
