package com.example.its.webUI.Controller.Projects;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import com.example.its.logic.AuthorityService;
import com.example.its.status.StatusManager;
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

    @GetMapping("projectid={projectID}/deletetester={userID}")
    public String projectAdminDeleteTester(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) {
        if(MainController.isUserLogin()== null){
            return "redirect:/";
        }
        service.deleteAuthority(new UserID(userID),StatusManager.getInstance().getProject(), Authority.AuthorityID.TESTER);
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("/projectid={projectID}/tester={userID}")
    public String projectAdminTester(@PathVariable("projectID") int projectID, @PathVariable("userID") String userID, Model model) {
        if(MainController.isUserLogin()== null){
            return "redirect:/";
        }
        StatusManager.getInstance().setProject(new ProjectID(projectID));
        service.createAuthority(new UserID(userID),StatusManager.getInstance().getProject(), Authority.AuthorityID.TESTER);
        return "redirect:/projects/admin/projectid="+projectID;
    }

    @GetMapping("/projectid={projectID}")
    public String projectAdmin(@PathVariable("projectID") int projectID, Model model) {
        if(MainController.isUserLogin()== null){
            return "redirect:/";
        }
        StatusManager.getInstance().setProject(new ProjectID(projectID));
        List<List<UserID>> list = service.readAuthorityListbyProject(StatusManager.getInstance().getProject());
        System.out.println(list.get(Authority.AuthorityID.TESTER.ordinal()).size());
        model.addAttribute("projectID", projectID);
        model.addAttribute("testerList", list.get(Authority.AuthorityID.TESTER.ordinal()));
        model.addAttribute("playerList", list.get(Authority.AuthorityID.PLAYER.ordinal()));
        model.addAttribute("developerList", list.get(Authority.AuthorityID.DEVELOPER.ordinal()));
        return "project_admin";
    }

}
