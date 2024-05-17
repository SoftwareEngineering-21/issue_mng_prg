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

    public static class Builder
    {
        // 필수 매개변수
        private String title;
        private String description;
        private String reporter;
        private int type;
        private int priority;
        private int status;
        private String date;

        //선택 매개변수
        private String assignee = null;
        private String fixer = null;

        public Builder assignee(String assignee)
        {
            this.assignee = assignee;
            return this;
        }

        public Builder fixer(String fixer)
        {
            this.fixer = fixer;
            return this;
        }

        public IssueDB build()
        {
            return new IssueDB(this);
        }
    }

    private IssueDB(Builder Builder)
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
