package com.example.its.webUI.Controller.Comment;

import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;
import com.example.its.logic.CommentService;
import com.example.its.logic.Exception.LoginRequiredException;

import com.example.its.state.StateManager;
import com.example.its.webUI.Controller.MainController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class CommentController {
    private final StateManager stateManager;
    private final CommentService commentService;

    @GetMapping("/projectid={projectID}/issueid={issueID}/create={comment}")
    public String addComment(@PathVariable("projectID") int projectID, @PathVariable("issueID") int issueID, @PathVariable("comment") String comment) throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        stateManager.setProject(new ProjectID(projectID));
        stateManager.setIssue(new IssueID(issueID));
        commentService.createComment(stateManager.getUser(), stateManager.getIssue(), comment,commentService.getCurrentDate());
        return "redirect:/projects/projectid="+projectID+"/issueid="+issueID+"?success=true";
    }
}
