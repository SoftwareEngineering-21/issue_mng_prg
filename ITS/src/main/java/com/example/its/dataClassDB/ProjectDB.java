package com.example.its.dataClassDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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
