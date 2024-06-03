package com.example.its.dataClassDB;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDB {
    private int ID;
    private String text;
    private String reporterComment;
    private Timestamp createdAt;

    public CommentDB(String text, String reporterComment)
    {
        this.text = text;
        this.reporterComment = reporterComment;
    }

    public CommentDB(String text, String reporterComment, Timestamp createdAt)
    {
        this.text = text;
        this.reporterComment = reporterComment;
        this.createdAt = createdAt;
    }

}
