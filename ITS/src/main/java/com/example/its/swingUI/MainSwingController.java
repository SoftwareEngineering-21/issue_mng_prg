package com.example.its.swingUI;

import java.util.List;

import com.example.its.dataClass.*;
import com.example.its.logic.*;
import com.example.its.logic.Exception.LoginFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.its.state.StateManager;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping
public class MainSwingController extends BaseController {
    protected UserService userService;
    protected AuthorityService authorityService;
    protected ProjectService projectService;
    protected IssueService issueService;
    protected CommentService commentService;

    @Autowired
    MainSwingController(StateManager stateManager, UserService userService, AuthorityService authorityService,
                        ProjectService projectService, IssueService issueService, CommentService commentService) {
        super(stateManager);
        this.userService = userService;
        this.authorityService = authorityService;
        this.projectService = projectService;
        this.issueService = issueService;
        this.commentService = commentService;
    }

    @Override
    public boolean login(String id, String password) {
        try{
            UserID user = userService.login(id, password);
            stateManager.setUser(user);
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

        List<Project> list = projectService.readProjects(userID());
        return list.toArray(new Project[] {});
    }

    @Override
    public boolean makeProject(String title, String Desc) {
        if(this.projectService == null){
            return false;
        }

        this.projectService.createProject(userID(), title, Desc);
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
            this.stateManager.setProject(projectId);
            this.stateManager.setAuthority(authorityService.getAuthorityThisProject(this.stateManager.getUser(), projectId));
            return project;
        }
        return null;
    }

    @Override
    public boolean addTester(UserID id) {
        return this.authorityService.createAuthority(id,
                stateManager.getProject(), Authority.AuthorityID.TESTER);
    }

    @Override
    public boolean addPlayer(UserID id) {
        return this.authorityService.createAuthority(id,
                stateManager.getProject(), Authority.AuthorityID.PLAYER);
    }

    @Override
    public boolean addDeveloper(UserID id) {
        return this.authorityService.createAuthority(id,
                stateManager.getProject(), Authority.AuthorityID.DEVELOPER);
    }

    @Override
    public UserID[] getTesterList() {
        List<List<UserID>> users =
                this.authorityService.readAuthorityListbyProject(this.stateManager.getProject());
        if(users == null){
            return null;
        }

        return users.get(Authority.AuthorityID.TESTER.ordinal()).toArray(new UserID[] {});
    }

    @Override
    public UserID[] getPlayerList() {
        List<List<UserID>> users =
                this.authorityService.readAuthorityListbyProject(this.stateManager.getProject());
        if(users == null){
            return null;
        }

        return users.get(Authority.AuthorityID.PLAYER.ordinal()).toArray(new UserID[] {});
    }

    @Override
    public UserID[] getDeveloperList() {
        List<List<UserID>> users =
            this.authorityService.readAuthorityListbyProject(this.stateManager.getProject());
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

        List<Issue> issueList = this.issueService.readIssueList(projectID(), null, null, null, null);

        if(issueList == null){
            return null;
        }
        return issueList.toArray(new Issue[]{});
    }

    @Override
    public boolean makeIssue(String title, String desc, int type, int priority) {
        Issue.TypeID _type;
        Issue.PriorityID _priority;

        try {
            _type=   Issue.TypeID.values()[type];
            _priority = Issue.PriorityID.values()[priority];
        }
        catch (Exception e) {
            return false;
        }
        this.issueService.createIssue(projectID(), title, desc, userID(), _type, _priority);
        return true;
    }

    @Override
    public Issue getIssue(IssueID id) {
        return issueService.readIssue(id);
    }

    @Override
    public Issue openIssue(IssueID id) {
        Issue target = getIssue(id);
        if(target != null){
            this.stateManager.setIssue(target.getID());
            return target;
        }
        return null;
    }

    @Override
    public boolean addComment(String desc) {
        this.commentService.createComment(this.stateManager.getUser(), this.stateManager.getIssue(), desc);
        return true;
    }

    @Override
    public boolean logout() {
        stateManager.setUser(null);
        return true;
    }

    @Override
    public Comment[] getCommentList() {
        if(this.commentService == null){
            return null;
        }

        List<Comment> list = this.commentService.readCommentsByIssueID(this.stateManager.getIssue());
        if(list == null){
            return null;
        }
        return list.toArray(new Comment[] {});
    }

    @Override
    public boolean deleteTester(UserID id) {
        this.authorityService.deleteAuthority(id, stateManager.getProject(), Authority.AuthorityID.TESTER);
        return true;
    }

    @Override
    public boolean deletePlayer(UserID id) {
        this.authorityService.deleteAuthority(id, stateManager.getProject(), Authority.AuthorityID.PLAYER);
        return true;
    }

    @Override
    public boolean deleteDeveloper(UserID id) {
        this.authorityService.deleteAuthority(id, stateManager.getProject(), Authority.AuthorityID.DEVELOPER);
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