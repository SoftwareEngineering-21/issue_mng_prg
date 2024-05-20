package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectDB {
    private int ID;
    private String title;
    private String description;
    private String adminID;

    public ProjectDB(String title, String description, String adminID)
    {
        this.title = title;
        this.description = description;
        this.adminID = adminID;
    }
    
}
