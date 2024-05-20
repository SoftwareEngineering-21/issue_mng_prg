package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ICRelationDB {
    private int issueID;
    private int commentID;

    public ICRelationDB(int issueID, int commentID)
    {
        this.issueID = issueID;
        this.commentID = commentID;
    }

}
