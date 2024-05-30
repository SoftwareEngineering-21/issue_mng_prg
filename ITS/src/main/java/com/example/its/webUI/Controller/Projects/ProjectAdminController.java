package com.example.its.webUI.Controller.Projects;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.logic.AuthorityService;
import com.example.its.logic.ProjectService;
import com.example.its.status.StatusManager;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.webUI.Controller.MainController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects/admin")
@RequiredArgsConstructor
public class ProjectAdminController {

    private final AuthorityService service;
    private final ProjectService projectService;
    private final StatusManager statusManager;

    @GetMapping("projectid={projectID}/deletetester={userID}")
    public String projectAdminDeleteTester(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        statusManager.setProject(new ProjectID(projectID));
        service.deleteAuthority(new UserID(userID),statusManager.getProject(), Authority.AuthorityID.TESTER);
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("project={projectID}/deleteplayer={userID}")
    public String projectAdminDeletePlayer(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        statusManager.setProject(new ProjectID(projectID));
        service.deleteAuthority(new UserID(userID),statusManager.getProject(), Authority.AuthorityID.PLAYER);
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("projectid={projectID}/deletedeveloper={userID}")
    public String projectAdminDeleteDeveloper(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        statusManager.setProject(new ProjectID(projectID));
        service.deleteAuthority(new UserID(userID),statusManager.getProject(), Authority.AuthorityID.DEVELOPER);
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("/projectid={projectID}/tester={userID}")
    public String projectAdminTester(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        statusManager.setProject(new ProjectID(projectID));
        boolean success = service.createAuthority(new UserID(userID),statusManager.getProject(), Authority.AuthorityID.TESTER);
        return "redirect:/projects/admin/projectid="+projectID+"?success="+success;
    }

    @GetMapping("/projectid={projectID}/player={userID}")
    public String projectAdminPlayer(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        statusManager.setProject(new ProjectID(projectID));
        boolean success = service.createAuthority(new UserID(userID),statusManager.getProject(), Authority.AuthorityID.PLAYER);
        return "redirect:/projects/admin/projectid="+projectID+"?success="+success;
    }

    @GetMapping("/projectid={projectID}/developer={userID}")
    public String projectAdminDeveloper(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        statusManager.setProject(new ProjectID(projectID));
        boolean success= service.createAuthority(new UserID(userID),statusManager.getProject(), Authority.AuthorityID.DEVELOPER);
        return "redirect:/projects/admin/projectid="+projectID+"?success="+success;
    }

    @GetMapping("/projectid={projectID}")
    public String projectAdmin(@PathVariable("projectID") int projectID,@RequestParam(value = "success", required = false)boolean success, Model model) throws LoginRequiredException {
        MainController.isUserLogin(statusManager);
        statusManager.setProject(new ProjectID(projectID));
        List<List<UserID>> list = service.readAuthorityListbyProject(statusManager.getProject());
        model.addAttribute("success", success);
        model.addAttribute("projectID", projectID);
        model.addAttribute("project",projectService.readProject(statusManager.getProject()));
        model.addAttribute("testerList", list.get(Authority.AuthorityID.TESTER.ordinal()));
        model.addAttribute("playerList", list.get(Authority.AuthorityID.PLAYER.ordinal()));
        model.addAttribute("developerList", list.get(Authority.AuthorityID.DEVELOPER.ordinal()));
        return "project_admin";
    }

}
