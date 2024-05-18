package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectDB {
    private int id;
    private String title;
    private String description;
    private String adminId;

    public ProjectDB(String title, String description, String adminId)
    {
        this.title = title;
        this.description = description;
        this.adminId = adminId;
    }
    
}
