package com.example.its.dataClassDB;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IssueDB {
    private int ID;
    private String title;
    private String description;
    private String reporter;
    private String assignee;
    private String fixer;
    private int type;
    private int priority;
    private int status;
    private Timestamp createdAt;

    //assignee랑 fixer 는 null로 받기
    public IssueDB(String title, String description, String reporter, String assignee, String fixer, int type, int priority, int status)
    {
        this.title = title;
        this.description = description;
        this.reporter = reporter;
        this.assignee = assignee;
        this.type = type;
        this.priority = priority;
        this.status = status;
    }

}
