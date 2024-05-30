package com.example.its.webUI.Controller.Issue;


import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.logic.IssueService;
import com.example.its.logic.ProjectService;
import com.example.its.status.StatusManager;
import com.example.its.webUI.Controller.MainController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class IssuesController {

    private final StatusManager statusManager;
    private final IssueService issueService;
    private final ProjectService projectService;

    @GetMapping("/projectid={projectID}")
    public String issues(@PathVariable("projectID") int projectID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        //현재 접근중인 projectID
        statusManager.setProject(new ProjectID(projectID));
        model.addAttribute("issueList", issueService.readIssueList(new ProjectID(projectID),null,null,null,null));
        model.addAttribute("projectID", projectID);
        model.addAttribute("issueListNum", issueService.readIssueList(new ProjectID(projectID),null,null,null,null).size());
        model.addAttribute("project", projectService.readProject(new ProjectID(projectID)));
        return "issues";
    }

}
