package com.example.its.database.authority;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.its.dataClassDB.AuthorityDB;

@Mapper
public interface AuthorityDBMapper {
    Integer createAuthority(AuthorityDB authority);
    AuthorityDB readAuthority(int ID);
    List<AuthorityDB> readAuthorityListbyProject(int projectID);
    List<AuthorityDB> readAuthorityListbyUser(String userID);
    void deleteAuthority(int ID);

    
}
