package com.example.its.logic;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import com.example.its.logic.authorityHandling.userAuth;
import com.example.its.logic.authorityHandling.userDeveloper;
import com.example.its.logic.authorityHandling.userPlayer;
import com.example.its.logic.authorityHandling.userTester;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorityService {
    private final DBService service;

    public List<List<UserID>> readAuthorityListbyProject(ProjectID projectID){
        return service.readAuthorityListbyProject(projectID);
    }

    public void deleteAuthority(UserID userID,ProjectID projectID,Authority.AuthorityID authority){
        EnumSet<Authority.AuthorityID> auth = service.readAuthorityListbyAll(userID, projectID).getAuthority();
        if(auth.contains(authority)){
            service.deleteAuthority(userID, projectID, authority.ordinal());
        }
    }

    public boolean createAuthority(UserID userID, ProjectID projectID, Authority.AuthorityID authority){
        if(service.readUser(userID)==null) return false;
        EnumSet<Authority.AuthorityID> auth = service.readAuthorityListbyAll(userID, projectID).getAuthority();
        if(!auth.contains(authority)){
            service.createAuthority(userID, projectID, authority.ordinal());
            return true;
        }
        return false;
    }

    @Deprecated
    public Authority getAuthorityThisProject(UserID userID, ProjectID projectID) {
        if(service.readUser(userID)==null) return null;

        Project project = service.readProject(projectID);
        if(project==null) return null;
        return service.readAuthorityListbyAll(userID, projectID);
    }

    public List<userAuth> getAuthListInProject(ProjectID projectID, UserID userID){
        Authority a = service.readAuthorityListbyAll(userID, projectID);
        List<userAuth> returnAuthes = new ArrayList<>();

        if(a.getAuthority().contains(Authority.AuthorityID.PLAYER)){
            returnAuthes.add(new userPlayer());
        }
        if(a.getAuthority().contains(Authority.AuthorityID.DEVELOPER)){
            returnAuthes.add(new userDeveloper());
        }
        if(a.getAuthority().contains(Authority.AuthorityID.TESTER)){
            returnAuthes.add(new userTester());
        }
        return returnAuthes;
    }
}
