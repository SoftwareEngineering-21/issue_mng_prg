package com.example.its.webUI.Controller;

import lombok.Getter;

@Getter
public class Project {
    private int projectID;
    private String title;
    private String description;
    public Project(int projectID, String title, String description) { this.projectID = projectID; this.description = description; this.title = title;}


}
