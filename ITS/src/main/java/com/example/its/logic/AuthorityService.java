package com.example.its.logic;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.database.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorityService {
    private final DBService service;

    public List<List<UserID>> readAuthorityListbyProject(ProjectID projectID){
        return service.readAuthorityListbyProject(projectID);

    }



    public void createAuthority(UserID userID, ProjectID projectID, int authority){
        service.createAuthority(userID, projectID, authority);
    }
}
