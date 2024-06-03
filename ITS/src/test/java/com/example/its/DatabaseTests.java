package com.example.its;


import com.example.its.dataClass.*;
import com.example.its.database.project.ProjectDBService;
import com.example.its.logic.*;
import com.example.its.logic.Exception.LoginFailureException;
import com.example.its.logic.authorityHandling.userAuth;
import com.example.its.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("dev")
public class DatabaseTests {

    @Autowired
    private UserService userService;

    @Autowired
    private IssueService issueService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private AuthorityService authorityService;

    UserID user1 = new UserID("test1");
    UserID user2 = new UserID("test2");
    UserID user3 = new UserID("test3");
    UserID user4 = new UserID("test4");

    @BeforeEach
    void serUp(){

    }

    @Test
    public void Login() throws LoginFailureException {
        //회원 가입과 로그인 테스트
        String id = "me";
        String password = "password";

        StateManager stateManager = new StateManager();

        userService.createUser(id, password);
        Assertions.assertDoesNotThrow(() -> { userService.login(id, password); });
        stateManager.setUser(userService.login(id, password));
        Assertions.assertEquals(id, stateManager.getUser().getID());

        //Project 생성 및 목록 불러오기 테스트
        List<Project> projectAdminList = projectService.readAdminProjects(stateManager.getUser());
        Assertions.assertEquals(0, projectAdminList.size());

        String title = "thisTitle";
        String description = "thisDescription";

        projectService.createProject(stateManager.getUser(), title, description);
        projectAdminList = projectService.readAdminProjects(stateManager.getUser());
        Assertions.assertEquals(1, projectAdminList.size());
        Assertions.assertEquals(title, projectAdminList.getFirst().getTitle());

        List<Project> projects = projectService.readProjects(user1);
        Assertions.assertEquals(1, projects.size());

        //권한 추가 테스트
        stateManager.setProject(projectAdminList.getFirst().getProjectID());

        authorityService.createAuthority(user1, stateManager.getProject(), Authority.AuthorityID.TESTER);
        authorityService.createAuthority(user2, stateManager.getProject(), Authority.AuthorityID.DEVELOPER);
        authorityService.createAuthority(user3, stateManager.getProject(), Authority.AuthorityID.PLAYER);

        List<List<UserID>> authorityList = authorityService.readAuthorityListbyProject(stateManager.getProject());
        for(int i = 0; i < authorityList.size(); i++){
            Assertions.assertEquals(authorityList.get(i).size(), 1);
        }

        Assertions.assertEquals(user1.getID(), authorityList.get(Authority.AuthorityID.TESTER.ordinal()).getFirst().getID());
        Assertions.assertEquals(user2.getID(), authorityList.get(Authority.AuthorityID.DEVELOPER.ordinal()).getFirst().getID());
        Assertions.assertEquals(user3.getID(), authorityList.get(Authority.AuthorityID.PLAYER.ordinal()).getFirst().getID());

        projects = projectService.readProjects(user1);
        Assertions.assertEquals(2, projects.size());

        authorityService.deleteAuthority(user1, stateManager.getProject(), Authority.AuthorityID.TESTER);
        authorityService.createAuthority(stateManager.getUser(), stateManager.getProject(), Authority.AuthorityID.TESTER);

        authorityList = authorityService.readAuthorityListbyProject(stateManager.getProject());
        Assertions.assertEquals(1, authorityList.get(Authority.AuthorityID.TESTER.ordinal()).size());
        Assertions.assertEquals(stateManager.getUser().getID(), authorityList.get(Authority.AuthorityID.TESTER.ordinal()).getFirst().getID());

        //Issue 추가 테스트
        String issueTitle = "문제가 생겼어요.";

        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));
        issueService.createIssue(stateManager.getUserAuthes(), "안녕하세요.", stateManager.getProject(), issueTitle, "과제가 안 끝나요.", stateManager.getUser(), Issue.TypeID.BUG, Issue.PriorityID.CRITICAL, commentService.getCurrentDate());
        List<Issue> issueList = issueService.readIssueList(stateManager.getProject(), null, null, null, null);

        Assertions.assertEquals(issueList.size(), 1);
        stateManager.setIssue(issueList.getFirst().getID());

        Issue issue = issueService.readIssue(stateManager.getIssue());

        Assertions.assertEquals(stateManager.getUser().getID(), issue.getReporter().getID());
        Assertions.assertEquals(Issue.StatusID.NEW, issue.getStatus());
        Assertions.assertEquals(Issue.TypeID.BUG, issue.getType());
        Assertions.assertEquals(Issue.PriorityID.CRITICAL, issue.getPriority());
        Assertions.assertEquals(issueTitle, issue.getTitle());

        //Comment 추가 테스트
        List<Comment> comments = commentService.readCommentsByIssueID(stateManager.getIssue());
        Assertions.assertEquals(1, comments.size());

        commentService.createComment(user1, stateManager.getIssue(), "Listen CareFully", commentService.getCurrentDate());
        commentService.createComment(user2, stateManager.getIssue(), "NONONONONO", commentService.getCurrentDate());

        comments = commentService.readCommentsByIssueID(stateManager.getIssue());
        Assertions.assertEquals(3, comments.size());

        Assertions.assertEquals(user1.getID(), comments.get(1).getAuthor().getID());
        Assertions.assertEquals(user2.getID(), comments.get(2).getAuthor().getID());
    }
}
