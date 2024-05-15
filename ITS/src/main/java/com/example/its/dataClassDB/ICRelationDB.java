package com.example.its.dataClassDB;

public class ICRelationDB {
    private int issueId;
    private int commentId;

    public ICRelationDB(int issueId, int commentId)
    {
        this.issueId = issueId;
        this.commentId = commentId;
    }

    public int readIssueId() {return this.issueId;}
    public int readCommentId() {return this.commentId;}
    public void updateIssueId(int issueId) {this.issueId=issueId;}
    public void updateCommentId(int commentId) {this.commentId=commentId;}
}
