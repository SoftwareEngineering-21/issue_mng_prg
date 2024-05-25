package com.example.its.dataClassDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDB {
    private int ID;
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
