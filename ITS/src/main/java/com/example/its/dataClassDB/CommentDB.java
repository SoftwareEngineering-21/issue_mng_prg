package com.example.its.dataClassDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDB {
    private int ID;
    private String text;
    private String reporter;
    private String date;

    public CommentDB(String text, String reporter, String date)
    {
        this.text = text;
        this.reporter = reporter;
        this.date = date;
    }

}
