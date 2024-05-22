package com.example.its.dataClassDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ICRelationDB {
    private int ID;
    private int issueID;
    private int commentID;

    public ICRelationDB(int issueID, int commentID)
    {
        this.issueID = issueID;
        this.commentID = commentID;
    }

}
