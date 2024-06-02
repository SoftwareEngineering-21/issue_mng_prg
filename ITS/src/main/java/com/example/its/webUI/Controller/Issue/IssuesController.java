package com.example.its.webUI.Controller.Issue;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;
import com.example.its.logic.CommentService;
import com.example.its.logic.IssueService;
import com.example.its.logic.ProjectService;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.state.StateManager;
import com.example.its.webUI.Controller.MainController;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class IssuesController {

    private final StateManager stateManager;
    private final IssueService issueService;
    private final ProjectService projectService;
    private final CommentService commentService;
    

    @GetMapping("/projectid={projectID}")
    public String issues(@PathVariable("projectID") int projectID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        stateManager.setProject(new ProjectID(projectID));
        //권한 stateManager에 저장
        stateManager.setUserAuthes(issueService.makeAuthList(stateManager.getProject(), stateManager.getUser()));
        model.addAttribute("issueList", issueService.readIssueList(new ProjectID(projectID),null,null,null,null));
        model.addAttribute("projectID", projectID);
        model.addAttribute("issueListNum", issueService.readIssueList(new ProjectID(projectID),null,null,null,null).size());
        model.addAttribute("project", projectService.readProject(new ProjectID(projectID)));
        return "issues";
    }

    @GetMapping("/projectid={projectID}/issueid={issueID}")
    public String issue(@PathVariable("projectID") int projectID, @PathVariable("issueID") int issueID, Model model) throws LoginRequiredException{
        MainController.isUserLogin(stateManager);
        stateManager.setProject(new ProjectID(projectID));
        stateManager.setIssue(new IssueID(issueID));
        model.addAttribute("projectID", projectID);
        model.addAttribute("issueID", issueID);
        model.addAttribute("issue", issueService.readIssue(new IssueID(issueID)));
        model.addAttribute("commentCount", commentService.readCommentsByIssueID(stateManager.getIssue()).size());
        model.addAttribute("commentList", commentService.readCommentsByIssueID(stateManager.getIssue()));
        return "issue";
    }


    @GetMapping("/projects/issue/modify/projectid={projectID}/issueid={issueID}")
    public String modifyIssue(){
        return "";

    }


}
