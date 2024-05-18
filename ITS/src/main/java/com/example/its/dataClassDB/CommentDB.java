package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDB {
    private int id;
    private String text;
    private String reporter;
    private String date;

    public CommentDB(int id, String text, String reporter, String date)
    {
        this.id = id;
        this.text = text;
        this.reporter = reporter;
        this.date = date;
    }

}
