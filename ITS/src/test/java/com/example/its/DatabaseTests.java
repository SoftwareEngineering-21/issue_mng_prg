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

    StateManager stateManager;

    UserID Admin;
    UserID user1 = new UserID("test1");
    UserID user2 = new UserID("test2");
    UserID user3 = new UserID("test3");

    @BeforeEach
    void serUp(){
        stateManager = new StateManager();
    }

    @Test
    public void TestCase() throws LoginFailureException {
        //회원 가입과 로그인 테스트
        String id = "me";
        String password = "password";

        Assertions.assertThrows(LoginFailureException.class, () -> { userService.login(id, password); });

        userService.createUser(id, password);

        Assertions.assertThrows(LoginFailureException.class, () -> { userService.login(id, "Password"); });

        Assertions.assertDoesNotThrow(() -> { userService.login(id, password); });
        Admin = userService.login(id, password);
        stateManager.setUser(Admin);
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

        //user1에게 Tester 권한 부여
        authorityService.createAuthority(user1, stateManager.getProject(), Authority.AuthorityID.TESTER);
        //user2에게 developer 권한 부여
        authorityService.createAuthority(user2, stateManager.getProject(), Authority.AuthorityID.DEVELOPER);
        //user3에게 player 권한 부여
        authorityService.createAuthority(user3, stateManager.getProject(), Authority.AuthorityID.PLAYER);

        List<List<UserID>> authorityList = authorityService.readAuthorityListbyProject(stateManager.getProject());
        for(int i = 0; i < authorityList.size(); i++){
            Assertions.assertEquals(1, authorityList.get(i).size());
        }

        Assertions.assertEquals(user1.getID(), authorityList.get(Authority.AuthorityID.TESTER.ordinal()).getFirst().getID());
        Assertions.assertEquals(user2.getID(), authorityList.get(Authority.AuthorityID.DEVELOPER.ordinal()).getFirst().getID());
        Assertions.assertEquals(user3.getID(), authorityList.get(Authority.AuthorityID.PLAYER.ordinal()).getFirst().getID());

        projects = projectService.readProjects(user1);
        Assertions.assertEquals(2, projects.size());

        //user1의 tester 권한 삭제
        authorityService.deleteAuthority(user1, stateManager.getProject(), Authority.AuthorityID.TESTER);

        authorityList = authorityService.readAuthorityListbyProject(stateManager.getProject());
        Assertions.assertEquals(0, authorityList.get(Authority.AuthorityID.TESTER.ordinal()).size());

        projects = projectService.readProjects(user1);
        Assertions.assertEquals(1, projects.size());
        
        //admin에게 tester 권한 부여
        authorityService.createAuthority(stateManager.getUser(), stateManager.getProject(), Authority.AuthorityID.TESTER);

        authorityList = authorityService.readAuthorityListbyProject(stateManager.getProject());
        Assertions.assertEquals(1, authorityList.get(Authority.AuthorityID.TESTER.ordinal()).size());
        Assertions.assertEquals(stateManager.getUser().getID(), authorityList.get(Authority.AuthorityID.TESTER.ordinal()).getFirst().getID());

        //Issue 추가 테스트
        String issueTitle = "문제가 생겼어요.";

        //user2의 issue 생성 시도
        List<userAuth> user2Auth = authorityService.getAuthListInProject(stateManager.getProject(), user2);
        issueService.createIssue(user2Auth, "안녕하세요.", stateManager.getProject(), issueTitle,
                "과제가 안 끝나요.", user2, Issue.TypeID.BUG, Issue.PriorityID.CRITICAL, commentService.getCurrentDate());

        List<Issue> issueList = issueService.readIssueList(stateManager.getProject(), null, null, null, null);
        Assertions.assertEquals(0, issueList.size());

        //Admin의 issue 생성 시도
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));
        issueService.createIssue(stateManager.getUserAuthes(), "안녕하세요.", stateManager.getProject(), issueTitle,
                "과제가 안 끝나요.", stateManager.getUser(), Issue.TypeID.BUG, Issue.PriorityID.CRITICAL, commentService.getCurrentDate());

        issueList = issueService.readIssueList(stateManager.getProject(), null, null, null, null);
        Assertions.assertEquals(1, issueList.size());
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

        commentService.createComment(user3, stateManager.getIssue(), "Listen CareFully", commentService.getCurrentDate());
        commentService.createComment(user2, stateManager.getIssue(), "NONONONONO", commentService.getCurrentDate());

        comments = commentService.readCommentsByIssueID(stateManager.getIssue());
        Assertions.assertEquals(3, comments.size());

        Assertions.assertEquals(user3.getID(), comments.get(1).getAuthor().getID());
        Assertions.assertEquals(user2.getID(), comments.get(2).getAuthor().getID());

        //*
        //tester인 admin이 new 상태의 issue 수정
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));
        for(userAuth auth : stateManager.getUserAuthes()){
            if(auth.isAvailable(issue, stateManager.getUser(), user2)){
                issueService.updateIssue(stateManager.getUser(), stateManager.getUserAuthes(), null, stateManager.getUser(), stateManager.getIssue(),
                        null, "", stateManager.getUser(), user2, user2, null, null, Issue.StatusID.ASSIGNED, commentService.getCurrentDate());
            }
        }

        issue = issueService.readIssue(stateManager.getIssue());

        Assertions.assertEquals(stateManager.getUser().getID(), issue.getReporter().getID());
        Assertions.assertNotEquals(Issue.StatusID.ASSIGNED, issue.getStatus());
        Assertions.assertEquals(Issue.StatusID.NEW, issue.getStatus());
        Assertions.assertNull(issue.getAssignee());
        Assertions.assertNull(issue.getFixer());

//        //player인 user3의 new 상태 issue 수정(assignee 미정)
//        for(userAuth auth : authorityService.getAuthListInProject(stateManager.getProject(), user3)){
//            if(auth.isAvailable(issue, user3, null)){
//                issueService.updateIssue(user3, stateManager.getUserAuthes(), null,user3, stateManager.getIssue(),
//                        null, "", user3, null, null, null, null, Issue.StatusID.ASSIGNED, commentService.getCurrentDate());
//            }
//        }
//
//        issue = issueService.readIssue(stateManager.getIssue());
//
//        Assertions.assertEquals(stateManager.getUser().getID(), issue.getReporter().getID());
//        Assertions.assertNotEquals(Issue.StatusID.ASSIGNED, issue.getStatus());
//        Assertions.assertEquals(Issue.StatusID.NEW, issue.getStatus());
//        Assertions.assertNotEquals(user2.getID(), issue.getReporter().getID());
//        Assertions.assertNull(issue.getFixer());
        //*/

        //Admin의 issue 추가 생성
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));
        issueService.createIssue(stateManager.getUserAuthes(), "화이팅", stateManager.getProject(), "제목",
                "힘내야지.", stateManager.getUser(), Issue.TypeID.NEW_FEATURE, Issue.PriorityID.MAJOR, commentService.getCurrentDate());

        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));
        issueService.createIssue(stateManager.getUserAuthes(), "화", stateManager.getProject(), "제",
                "힘.", stateManager.getUser(), Issue.TypeID.NEW_FEATURE, Issue.PriorityID.MAJOR, commentService.getCurrentDate());

        issueList = issueService.readIssueList(stateManager.getProject(), null, null, null, null);
        Assertions.assertEquals(3, issueList.size());

        //player인 user3의 new 상태 issue 수정(assignee 설정)
        stateManager.setUser(user3);
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));

        //New 상태 Issue 검색
        issueList = issueService.readIssueList(stateManager.getProject(), null, null, Issue.StatusID.NEW, null);
        Assertions.assertEquals(3, issueList.size());
        stateManager.setIssue(issueList.getFirst().getID());


        for(userAuth auth : stateManager.getUserAuthes()){
            if(auth.isAvailable(issue, stateManager.getUser(), user2)){
                issueService.updateIssue(stateManager.getUser(), stateManager.getUserAuthes(), null, stateManager.getUser(), stateManager.getIssue(),
                        null, "", null, user2, null, null, null, Issue.StatusID.ASSIGNED, commentService.getCurrentDate());
            }
        }
        issue = issueService.readIssue(stateManager.getIssue());

        Assertions.assertEquals(Admin.getID(), issue.getReporter().getID());
        Assertions.assertEquals(Issue.StatusID.ASSIGNED, issue.getStatus());
        Assertions.assertNull(issue.getFixer());

        issueList = issueService.readIssueList(stateManager.getProject(), null, null, Issue.StatusID.NEW, null);
        Assertions.assertEquals(2, issueList.size());

        //developer인 user2의 issue 수정
        stateManager.setUser(user2);
        stateManager.setUserAuthes(authorityService.getAuthListInProject(stateManager.getProject(), stateManager.getUser()));

        issueList = issueService.readIssueList(stateManager.getProject(), null, user2, null, null);
        Assertions.assertEquals(1, issueList.size());
        stateManager.setIssue(issueList.getFirst().getID());

        for(userAuth auth : stateManager.getUserAuthes()){
            if(auth.isAvailable(issue, stateManager.getUser(), null)){
                issueService.updateIssue(stateManager.getUser(), stateManager.getUserAuthes(), null, stateManager.getUser(), stateManager.getIssue(), null,
                        "", null, null, stateManager.getUser(), null, null, Issue.StatusID.FIXED, commentService.getCurrentDate());
            }
        }
        issue = issueService.readIssue(stateManager.getIssue());

        Assertions.assertEquals(Admin.getID(), issue.getReporter().getID());
        Assertions.assertEquals(Issue.StatusID.FIXED, issue.getStatus());
        Assertions.assertEquals(stateManager.getUser().getID(), issue.getFixer().getID());

        issueList = issueService.readIssueList(stateManager.getProject(), null, user2, Issue.StatusID.ASSIGNED, null);
        Assertions.assertEquals(0, issueList.size());
    }
}
