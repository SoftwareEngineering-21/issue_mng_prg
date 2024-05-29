package com.example.its.database.authority;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.AuthorityDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityDBManager {
    private final AuthorityDBMapper authorityDB;

    public void createAuthorityManager(String userID, int projectID, int auth){
        AuthorityDB authority = new AuthorityDB(userID, projectID, auth);
        authorityDB.createAuthority(authority);
    }

    public List<AuthorityDB> readAuthorityListbyProjectManager(int projectID){
        return authorityDB.readAuthorityListbyProject(projectID);
    }

    public List<AuthorityDB> readAuthorityListbyAllManager(String userID, int projectID){
        return authorityDB.readAuthorityListbyAll(userID, projectID);
    }

    public List<AuthorityDB> readAuthorityListbyAuthinPManager(int projectID, int auth){
        return authorityDB.readAuthorityListbyAuthinP(projectID, auth);
    }

    void deleteAuthorityManager(String userID, int projectID, int auth){
        authorityDB.deleteAuthority(userID, projectID, auth);
    }
    
}
