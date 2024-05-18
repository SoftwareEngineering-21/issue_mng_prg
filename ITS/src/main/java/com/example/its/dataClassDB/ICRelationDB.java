package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ICRelationDB {
    private int issueId;
    private int commentId;

    public ICRelationDB(int issueId, int commentId)
    {
        this.issueId = issueId;
        this.commentId = commentId;
    }

}
