package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IssueDB {
    private int id;
    private String title;
    private String description;
    private String reporter;
    private String assignee;
    private String fixer;
    private int type;
    private int priority;
    private int status;
    private String date;

    //assignee 있는 생성자
    public IssueDB(String title, String description, String reporter, String assignee, int type, int priority, int status, String date)
    {
        this.title = title;
        this.description = description;
        this.reporter = reporter;
        this.assignee = assignee;
        this.type = type;
        this.priority = priority;
        this.status = status;
        this.date = date;
    }

    //assignee 없는 생성자
    public IssueDB(String title, String description, String reporter, int type, int priority, int status, String date)
    {
        this.title = title;
        this.description = description;
        this.reporter = reporter;
        this.type = type;
        this.priority = priority;
        this.status = status;
        this.date = date;
    }

}
