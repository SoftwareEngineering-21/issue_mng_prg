package com.example.its.webUI.Controller;

import lombok.Getter;

@Getter
public class Project {
    private ProjectID projectID;
    private String title;
    private String description;
    public Project(ProjectID projectID, String title, String description) { this.projectID = projectID; this.description = description; this.title = title;}


}
