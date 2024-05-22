package com.example.its.dataClassDB;

import lombok.Getter;

@Getter
public class CommentDB {
    private int ID;
    private String text;
    private String reporter;
    private String date;

    public CommentDB(int ID, String text, String reporter, String date)
    {
        this.ID = ID;
        this.text = text;
        this.reporter = reporter;
        this.date = date;
    }

}
