package com.example.its.webUI.Controller.Issue;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.logic.AuthorityService;
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
    private final AuthorityService authorityService;

    @GetMapping("/projectid={projectID}/create")
    public String createProject(Model model, @PathVariable("projectID") int projectID)
    {
        return "issue_create";
    }

    @PostMapping("/projectid={projectID}/create")
    public String createProject(@RequestParam("title")String title, @RequestParam("description") String description,Model model, @PathVariable("projectID") int projectID){

        return "redirect:/projects/projectid="+projectID;
    }

    @GetMapping("/projectid={projectID}")
    public String issues(@PathVariable("projectID") int projectID, @RequestParam("success") boolean success, @RequestParam(name="option" ,required = false) String option,@RequestParam(name ="input",required = false) String input, Model model) throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        stateManager.setProject(new ProjectID(projectID));
        stateManager.setIssue(null);
        //권한 stateManager에 저장
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));
        List<Issue> list = issueService.readIssueList(new ProjectID(projectID),null,null,null,null);
        List<Issue> fList = new ArrayList();
        
        if(input == null||input.equals("")){
            model.addAttribute("issueList", list);
        }
        else{
            switch(option){
            case "status":
            Issue.StatusID statusID= null;
            if(input.equals("new")){
                statusID = Issue.StatusID.NEW;
            }
            System.out.println("ass");
        
                for(Issue i : list){
                    if(i.getStatus()==statusID){
                        fList.add(i);
                    }
                }
                break;
            case "assignee":
                for(Issue i:list){
                    if(i.getAssignee().getID().equals(input)){
                        fList.add(i);
                    }
                }


            }
        }

        
        model.addAttribute("projectID", projectID);
        model.addAttribute("success", success);
        model.addAttribute("issueListNum", issueService.readIssueList(new ProjectID(projectID),null,null,null,null).size());
        model.addAttribute("project", projectService.readProject(new ProjectID(projectID)));
        return "issues";
    }

    @GetMapping("/projectid={projectID}/issueid={issueID}")
    public String issue(@PathVariable("projectID") int projectID, @PathVariable("issueID") int issueID,@RequestParam("success")boolean success, Model model) throws LoginRequiredException{
        MainController.isUserLogin(stateManager);
        stateManager.setProject(new ProjectID(projectID));
        stateManager.setIssue(new IssueID(issueID));
        //권한 stateManager에 저장
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));

        model.addAttribute("projectID", projectID);
        model.addAttribute("issueID", issueID);
        model.addAttribute("issue", issueService.readIssue(new IssueID(issueID)));
        model.addAttribute("commentCount", commentService.readCommentsByIssueID(stateManager.getIssue()).size());
        model.addAttribute("commentList", commentService.readCommentsByIssueID(stateManager.getIssue()));
        model.addAttribute("success", success);
        return "issue";
    }


    @GetMapping("/modify/projectid={projectID}/issueid={issueID}")
    public String modifyIssue(@PathVariable("projectID")int projectID, @PathVariable("issueID") int issueID,  Model model) throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        stateManager.setProject(new ProjectID(projectID));
        stateManager.setIssue(new IssueID(issueID));
        //권한 stateManager에 저장
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));
        if(!issueService.isAvailable(stateManager.getUserAuthes(),stateManager.getIssue(),stateManager.getUser())){
            return "redirect:/projects/projectid="+projectID+"/issueid="+issueID+"?success=false";
        }
        List<List<UserID>> list = authorityService.readAuthorityListbyProject(stateManager.getProject());
        UserID id = stateManager.getUser();
        model.addAttribute("projectID", projectID);
        model.addAttribute("issueID", issueID);
        model.addAttribute("issue", issueService.readIssue(new IssueID(issueID)));
        model.addAttribute("username", id.getID());
        if( issueService.readIssue(new IssueID(issueID)).getAssignee()!=null){
            UserID assignee = issueService.readIssue(new IssueID(issueID)).getAssignee();
            model.addAttribute("developerList",assignee);

        }
        else{
            model.addAttribute("developerList", list.get(Authority.AuthorityID.DEVELOPER.ordinal()));
        }
        model.addAttribute("commentList", commentService.readCommentsByIssueID(stateManager.getIssue()));
        model.addAttribute("testerList", list.get(Authority.AuthorityID.TESTER.ordinal()));
        model.addAttribute("playerList", list.get(Authority.AuthorityID.PLAYER.ordinal()));
        model.addAttribute("recommend",issueService.recommendDeveloper(stateManager.getProject(),stateManager.getIssue()));
        return "issue_modify";

    }

    @GetMapping("/modify/projectid={projectID}/issueid={issueID}/reporter={reporter}/assignee={assignee}/fixer={fixer}/status={status}/comment={comment}")
    public String modifyResult(@PathVariable("projectID")int projectID,@PathVariable("issueID") int issueID, @PathVariable("reporter") String reporter, @PathVariable("assignee") String assignee ,@PathVariable("fixer") String fixer, @PathVariable("status") String status, @PathVariable("comment") String comment, Model model) throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        if(fixer.equals("null")){
            fixer = null;
        }
        if(assignee.equals("null") )
            assignee = null;
        if(reporter.equals("null") )
            reporter = null;
        Issue.StatusID statusID = null;
        switch(status){
            case "new":
                statusID = Issue.StatusID.NEW;
                break;
            case "assigned":
                statusID = Issue.StatusID.ASSIGNED;
                break;
            case "fixed":
                statusID =Issue.StatusID.FIXED;
                break;
            case "resolved":
                statusID = Issue.StatusID.RESOLVED;
                break;
            case "reopen":
                statusID = Issue.StatusID.REOPENED;
                assignee = null;
                fixer = null;
                break;
            case "closed":
                statusID = Issue.StatusID.CLOSED;
                break;
        }
        issueService.updateIssue(stateManager.getUser(),stateManager.getUserAuthes(),comment,stateManager.getUser(),stateManager.getIssue(),null,comment,new UserID(reporter),new UserID(assignee),new UserID(fixer),null,null,statusID,commentService.getCurrentDate());
        MainController.isUserLogin(stateManager);
        return "redirect:/projects/projectid="+projectID+"/issueid="+issueID+"?success=true";
    }

    @GetMapping("/issue/create/projectid={projectID}")
    public String createIssue(@PathVariable("projectID") int projectID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        if(!issueService.isAvailable(stateManager.getUserAuthes(),stateManager.getIssue(),stateManager.getUser())){
            return "redirect:/projects/projectid="+stateManager.getProject().getID()+"?success=false";
        }
        model.addAttribute("projectID", projectID);
        model.addAttribute("reporter", stateManager.getUser().getID());
        model.addAttribute("typeList", Issue.TypeID.values());
        model.addAttribute("priorityList", Issue.PriorityID.values());
        List<Issue.StatusID> statusList = List.of(Issue.StatusID.NEW);
        model.addAttribute("statusList", statusList);
        return "issue_create";
    }

    @PostMapping("/issue/create")
    public String postMethodName(@RequestParam("title")String title, @RequestParam("description") String description, @RequestParam("type") Issue.TypeID type, @RequestParam("priority") Issue.PriorityID priority,@RequestParam("status") Issue.StatusID status, @RequestParam("comment") String comment) throws LoginRequiredException{
        MainController.isUserLogin(stateManager);
//권한 stateManager에 저장
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));

        issueService.createIssue(stateManager.getUserAuthes(), comment, stateManager.getProject(), title, description, stateManager.getUser(), type, priority, commentService.getCurrentDate());
        return "redirect:/projects/projectid="+stateManager.getProject().getID()+"?success=true";
    }





}
