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
        String id = "me";
        String password = "password";

        StateManager stateManager = new StateManager();

        userService.createUser(id, password);
        Assertions.assertDoesNotThrow(() -> { userService.login(id, password); });
        stateManager.setUser(userService.login(id, password));
        Assertions.assertEquals(stateManager.getUser().getID(), id);

        String title = "thisTitle";
        String description = "thisDescription";

        projectService.createProject(stateManager.getUser(), title, description);
        List<Project> projectAdminList = projectService.readAdminProjects(stateManager.getUser());
        Assertions.assertEquals(projectAdminList.size(), 1);
        Assertions.assertEquals(projectAdminList.getFirst().getTitle(), title);

        stateManager.setProject(projectAdminList.getFirst().getProjectID());

        authorityService.createAuthority(user1, stateManager.getProject(), Authority.AuthorityID.TESTER);
        authorityService.createAuthority(user2, stateManager.getProject(), Authority.AuthorityID.DEVELOPER);
        authorityService.createAuthority(user3, stateManager.getProject(), Authority.AuthorityID.PLAYER);

        List<List<UserID>> authorityList = authorityService.readAuthorityListbyProject(stateManager.getProject());
        for(int i = 0; i < authorityList.size(); i++){
            Assertions.assertEquals(authorityList.get(i).size(), 1);
        }

        Assertions.assertEquals(authorityList.get(Authority.AuthorityID.TESTER.ordinal()).getFirst(), user1);
        Assertions.assertEquals(authorityList.get(Authority.AuthorityID.DEVELOPER.ordinal()).getFirst(), user2);
        Assertions.assertEquals(authorityList.get(Authority.AuthorityID.PLAYER.ordinal()).getFirst(), user3);

        
    }
}
