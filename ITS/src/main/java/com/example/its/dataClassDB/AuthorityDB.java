package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorityDB {
    private String userID;
    private int projectID;
    private int auth;

    public AuthorityDB(String userID, int projectID, int auth)
    {
        this.userID = userID;
        this.projectID = projectID;
        this.auth = auth;
    }


}
