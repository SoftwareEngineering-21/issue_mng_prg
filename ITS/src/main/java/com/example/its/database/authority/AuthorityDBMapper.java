package com.example.its.database.authority;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.its.dataClassDB.AuthorityDB;

@Mapper
public interface AuthorityDBMapper {
    void createAuthority(AuthorityDB authority);
    List<AuthorityDB> readAuthorityListbyProject(int projectID);
    List<AuthorityDB> readAuthorityListbyAll(@Param("userID") String userID, @Param("projectID") int projectID);
    void deleteAuthority(@Param("userID") String userID, @Param("projectID") int projectID, @Param("auth") int auth);
    List<AuthorityDB> readAuthorityListbyAuthinP(@Param("projectID") int projectID, @Param("auth") int auth);
    
}
