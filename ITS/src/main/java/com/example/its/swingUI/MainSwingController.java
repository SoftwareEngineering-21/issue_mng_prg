package com.example.its.swingUI;

import java.util.List;

import com.example.its.dataClass.*;
import com.example.its.logic.AuthorityService;
import com.example.its.webUI.Controller.Exception.LoginFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.its.logic.UserService;
import com.example.its.state.StateManager;
import com.example.its.logic.ProjectService;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping
public class MainSwingController extends BaseController {
    protected UserService userService;
    protected ProjectService projectService;
    protected AuthorityService authorityService;
    //protected IssueService issueService;

    @Autowired
    MainSwingController(UserService userService, ProjectService projectService,StatusManager statusManager, AuthorityService authorityService){
        super(statusManager);
        this.userService = userService;
        this.projectService = projectService;
        this.authorityService = authorityService;
    }

    @Override
    public boolean login(String id, String password) {
        try{
            UserID user = userService.login(id, password);
            statusManager.setUser(user);
        }
        catch (LoginFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isExistID(String id) {
        return userService.validateUser(id);
    }

    @Override
    public boolean signUp(String id, String password) {
        userService.createUser(id, password);
        return true;
    }

    @Override
    public Project[] getProjectList() {
        if(projectService == null){
            System.out.println("Error! projectService is null");
            return null;
        }

        List<Project> list = projectService.readProjects(statusManager.getUser());
        return list.toArray(new Project[] {});
    }

    @Override
    public boolean makeProject(String title, String Desc) {
        if(this.projectService == null){
            return false;
        }

        this.projectService.createProject(statusManager.getUser(), title, Desc);
        return true;
    }

    @Override
    public Project getProject(ProjectID projectId) {
        return this.projectService.readProject(projectId);
    }

    @Override
    public Project openProject(ProjectID projectId) {
        Project project = getProject(projectId);
        if(project != null){
            this.statusManager.setProject(projectId);
            return project;
        }
        return null;
    }

    @Override
    public boolean addTester(UserID id) {
        return this.authorityService.createAuthority(id,
                statusManager.getProject(), Authority.AuthorityID.TESTER);
    }

    @Override
    public boolean addPlayer(UserID id) {
        return this.authorityService.createAuthority(id,
                statusManager.getProject(), Authority.AuthorityID.PLAYER);
    }

    @Override
    public boolean addDeveloper(UserID id) {
        return this.authorityService.createAuthority(id,
                statusManager.getProject(), Authority.AuthorityID.DEVELOPER);
    }

    @Override
    public UserID[] getTesterList() {
        List<List<UserID>> users =
                this.authorityService.readAuthorityListbyProject(this.statusManager.getProject());
        if(users == null){
            return null;
        }

        return users.get(Authority.AuthorityID.TESTER.ordinal()).toArray(new UserID[] {});
    }

    @Override
    public UserID[] getPlayerList() {
        List<List<UserID>> users =
                this.authorityService.readAuthorityListbyProject(this.statusManager.getProject());
        if(users == null){
            return null;
        }

        return users.get(Authority.AuthorityID.PLAYER.ordinal()).toArray(new UserID[] {});
    }

    @Override
    public UserID[] getDeveloperList() {
        List<List<UserID>> users =
            this.authorityService.readAuthorityListbyProject(this.statusManager.getProject());
        if(users == null){
            return null;
        }

        return users.get(Authority.AuthorityID.DEVELOPER.ordinal()).toArray(new UserID[] {});
    }

    @Override
    public Issue[] getIssueList() {
        if(this.projectService == null){
            return null;
        }

        List<Issue> issueList = null;
        //issueList = this.projectService.getIssueList();

        if(issueList == null){
            return null;
        }
        return issueList.toArray(new Issue[]{});
    }

    @Override
    public boolean makeIssue(String title, String desc, int type, int priority) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeIssue'");
    }

    @Override
    public Issue getIssue(IssueID id) {
        return null;
    }

    @Override
    public Issue openIssue(IssueID id) {
        return null;
    }

    @Override
    public boolean addComment(String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addComment'");
    }

    @Override
    public boolean logout() {
        stateManager.setUser(null);
        return true;
    }

    @Override
    public Comment[] getCommentList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentList'");
    }

    @Override
    public boolean deleteTester(UserID id) {
        this.authorityService.deleteAuthority(id, statusManager.getProject(), Authority.AuthorityID.TESTER);
        return true;
    }

    @Override
    public boolean deletePlayer(UserID id) {
        this.authorityService.deleteAuthority(id, statusManager.getProject(), Authority.AuthorityID.PLAYER);
        return true;
    }

    @Override
    public boolean deleteDeveloper(UserID id) {
        this.authorityService.deleteAuthority(id, statusManager.getProject(), Authority.AuthorityID.DEVELOPER);
        return true;
    }

    @Override
    public Project[] getAdminProjectList() {
        List<Project> projects = this.projectService.readAdminProjects(stateManager.getUser());
        if(projects == null){
            return null;
        }
        return projects.toArray(new Project[]{});
    }
}