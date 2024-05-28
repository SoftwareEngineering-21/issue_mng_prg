package com.example.its.webUI.Controller.Projects;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import com.example.its.logic.AuthorityService;
import com.example.its.logic.ProjectService;
import com.example.its.status.StatusManager;
import com.example.its.webUI.Controller.Exception.LoginException;
import com.example.its.webUI.Controller.MainController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects/admin")
@RequiredArgsConstructor
public class ProjectAdminController {

    private final AuthorityService service;
    private final ProjectService projectService;

    @GetMapping("projectid={projectID}/deletetester={userID}")
    public String projectAdminDeleteTester(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginException {
        MainController.isUserLogin();
        service.deleteAuthority(new UserID(userID),StatusManager.getInstance().getProject(), Authority.AuthorityID.TESTER);
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("project={projectID}/deleteplayer={userID}")
    public String projectAdminDeletePlayer(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginException {
        MainController.isUserLogin();
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("/projectid={projectID}/tester={userID}")
    public String projectAdminTester(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) throws LoginException {
        MainController.isUserLogin();
        StatusManager.getInstance().setProject(new ProjectID(projectID));
        service.createAuthority(new UserID(userID),StatusManager.getInstance().getProject(), Authority.AuthorityID.TESTER);
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("/projectid={projectID}")
    public String projectAdmin(@PathVariable("projectID") int projectID, Model model) throws LoginException {
        MainController.isUserLogin();
        StatusManager.getInstance().setProject(new ProjectID(projectID));
        List<List<UserID>> list = service.readAuthorityListbyProject(StatusManager.getInstance().getProject());
        model.addAttribute("projectID", projectID);
        model.addAttribute("project",projectService.readProject(StatusManager.getInstance().getProject()));
        model.addAttribute("testerList", list.get(Authority.AuthorityID.TESTER.ordinal()));
        model.addAttribute("playerList", list.get(Authority.AuthorityID.PLAYER.ordinal()));
        model.addAttribute("developerList", list.get(Authority.AuthorityID.DEVELOPER.ordinal()));
        return "project_admin";
    }

}
