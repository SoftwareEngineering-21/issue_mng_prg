package com.example.its.database.authority;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.AuthorityDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityDBManager {
    private final AuthorityDBMapper authorityDB;

    public Integer createAuthorityManager(String userID, int projectID, int auth){
        AuthorityDB authority = new AuthorityDB(userID, projectID, auth);
        authorityDB.createAuthority(authority);
        return authority.getID();
    }

    public AuthorityDB readAuthorityManager(int ID){
        return authorityDB.readAuthority(ID);
    }

    public List<AuthorityDB> readAuthorityListbyProjectManager(int projectID){
        return authorityDB.readAuthorityListbyProject(projectID);
    }

    public List<AuthorityDB> readAuthorityListbyUserManager(String userID){
        return authorityDB.readAuthorityListbyUser(userID);
    }

    void deleteAuthorityManager(int ID){
        authorityDB.deleteAuthority(ID);
    }
    
}
