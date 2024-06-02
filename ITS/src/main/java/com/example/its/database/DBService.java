package com.example.its.database;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Comment;
import com.example.its.dataClass.CommentID;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.dataClass.UserSession;
import com.example.its.database.authority.AuthorityDBService;
import com.example.its.database.comment.CommentDBService;
import com.example.its.database.icrelation.ICRelationDBService;
import com.example.its.database.issue.IssueDBService;
import com.example.its.database.pirelation.PIRelationDBService;
import com.example.its.database.project.ProjectDBService;
import com.example.its.database.statistic.StatisticDBService;
import com.example.its.database.user.UserDBService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DBService {
    private final ProjectDBService projectDBService;
    private final UserDBService userDBService;
    private final AuthorityDBService authDBService;
    private final IssueDBService issueDBService;
    private final PIRelationDBService pIRelationDBService;
    private final CommentDBService commentDBService;
    private final ICRelationDBService icRelationDBService;
    private final StatisticDBService statisticDBService;

    //ProjectDB methods
    public ProjectID createProject(String title, String description, UserID adminID){
        return projectDBService.createProjectService(title, description, adminID);
    }

    public Project readProject(ProjectID projectID){
        return projectDBService.readProjectService(projectID);
    }

    public List<Project> readProjectList(UserID userID){
        return projectDBService.readProjectListService(userID);
    }

    public List<Project> readAdminProjectList(UserID userID){return projectDBService.readAdminProjectListService(userID);}

    public void updateProject(ProjectID projectID, String title, String description){
        projectDBService.updateProjectService(projectID, title, description);
    }

    public void deleteProject(ProjectID projectID){
        projectDBService.deleteProjectService(projectID);
    }




    public UserID createUser(String ID, String password){
        return userDBService.createUserService(ID, password);
    }

    public User readUser(UserID user){
        return userDBService.readUserService(user);
    }

    public UserSession readUserSession(UserID userID){
        return userDBService.readUserSessionService(userID);
    }



    public void deleteUser(UserID userID){
        userDBService.deleteUserSerivce(userID);
    }



    //Authority methods
    public void createAuthority(UserID userID, ProjectID projectID, int auth){
        authDBService.createAuthorityService(userID, projectID, auth);
    }

    public List<List<UserID>> readAuthorityListbyProject(ProjectID projectID){
        return authDBService.readAuthorityListbyProjectService(projectID);
    }

    public Authority readAuthorityListbyAll(UserID userID, ProjectID projectID){
        return authDBService.readAuthorityListbyAllService(userID, projectID);
    }

    public List<UserID> readAuthorityListbyAuthinP(ProjectID projectID, int auth){
        return authDBService.readAuthorityListbyAuthinPService(projectID, auth);
    }

    public void deleteAuthority(UserID userID, ProjectID projectID, int auth){
        authDBService.deleteAuthority(userID, projectID, auth);
    }



    //Issue methods
    public IssueID createIssue(ProjectID projectIDFK,String title, String description, UserID reporter, UserID assignee, UserID fixer, Issue.TypeID type, Issue.PriorityID priority, Issue.StatusID status){
        IssueID i = issueDBService.createIssueService(title, description, reporter, assignee, fixer, type, priority, status);
        pIRelationDBService.createPIRelationService(projectIDFK, i);
        return i;
    }

    public Issue readIssue(IssueID issueID){
        return issueDBService.readIssueService(issueID);
    }

    /**
     * @param projectIDFK not null
     * @param reporter nullable
     * @param assignee nullable
     * @param status nullable
     * @param sortOrder null -> desc, createdAt, status
     */
    public List<Issue> readIssueList(ProjectID projectIDFK, UserID reporter, UserID assignee, Integer status, String sortOrder){
        System.out.println(sortOrder);
        return issueDBService.readIssueListService(projectIDFK, reporter, assignee, status, sortOrder);
    }

    public void updateIssue(IssueID ID, String title, String description, UserID reporter, UserID assignee, UserID fixer, Integer type, Integer priority, Integer status){
        issueDBService.updateIssueService(ID, title, description, reporter, assignee, fixer, type, priority, status);
    }

    public void deleteIssue(IssueID ID){
        issueDBService.deleteIssueService(ID);
    }



    //Comment method
    public CommentID createComment(IssueID issueID, String text, UserID author, Date date){

        CommentID newC = commentDBService.createCommentService(text, author, new Timestamp(date.getTime()));
        icRelationDBService.createICRelationService(issueID, newC);
        return newC;
    }

    public Comment readComment(CommentID commentID){
        return commentDBService.readCommentService(commentID);
    }

    public List<Comment> readCommentList(IssueID issueID){
        return commentDBService.readCommentListService(issueID);
    }

    public void updateComment(CommentID commentID, String text){
        commentDBService.updateCommentService(commentID, text);
    }

    public void deleteComment(CommentID commentID){
        commentDBService.deleteCommentService(commentID);
    }



    //Statistic method
    // read all count of issue from each project
    public List<Pair<ProjectID, Integer>> countAllofUploadIssue(UserID userID, Timestamp startTime, Timestamp endTime){
        List<Project> admin = projectDBService.readAdminProjectListService(userID);
        List<Project> notAdmin = projectDBService.readProjectListService(userID);
        List<ProjectID> projectIDList = new ArrayList<>();

        for(Project p : admin){
            projectIDList.add(p.getProjectID());
        }
        for(Project p : notAdmin){
            projectIDList.add(p.getProjectID());
        }

        return statisticDBService.countAllofUploadIssueService(projectIDList, startTime, endTime);
    }

    //read issue count with type in same project
    public List<Pair<Issue.TypeID, Integer>> countAllTypeIssue(ProjectID projectIDFK, Timestamp startTime, Timestamp endTime){
        return statisticDBService.countAllTypeIssueService(projectIDFK, startTime, endTime);
    }

    // read issue count about assignee with status and type
    public List<Pair<UserID, Integer>> countIssuesByAssignee(ProjectID projectIDFK, Integer type, Integer status){
        List<Pair<UserID, Integer>> result = statisticDBService.countIssuesByAssigneeService(projectIDFK, type, status);
        List<UserID> allDev = authDBService.readAuthorityListbyAuthinPService(projectIDFK, 1);

        List<UserID> processedUserID = new ArrayList<>();
        for (Pair<UserID, Integer> pre : result){
            processedUserID.add(pre.getFirst());
        }

        for (UserID i : allDev){
            if (!processedUserID.contains(i)){
                Pair<UserID, Integer> temp = Pair.of(i, 0);
                result.add(temp);
            }
        }

        return result;
    }

    public List<Pair<Integer, Integer>> count3MostCommentinIssue(ProjectID projectIDFK){
        return statisticDBService.count3MostCommentinIssueService(projectIDFK);
    }

    public List<Pair<Issue.TypeID, BigDecimal>> countAvgofComment(ProjectID projectIDFK){
        return statisticDBService.countAvgofCommentService(projectIDFK);
    }


    // recommend dev
    public UserID recommendDev(ProjectID projectID, Issue.StatusID status, Issue.TypeID type){
        int intStatus  = (status != null) ? status.ordinal() : null;
        int intType  = (type != null) ? type.ordinal() : null;
        List<Pair<UserID, Integer>> statistic = countIssuesByAssignee(projectID, intStatus, intType);
        return statistic.get(0).getFirst();
    }


}
