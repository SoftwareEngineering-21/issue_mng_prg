package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorityDB {
    private String userId;
    private int projectId;
    private int auth;

    public AuthorityDB(String userId, int projectId, int auth)
    {
        this.userId = userId;
        this.projectId = projectId;
        this.auth = auth;
    }


}
