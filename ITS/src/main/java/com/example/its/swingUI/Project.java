package com.example.its.swingUI;

public class Project {
    private int ProjectId;
    private String title;
    private String decs;

    Project(int projectId, String title, String decs){
        this.ProjectId = projectId;
        this.title = title;
        this.decs = decs;
    }

    String getTitle(){
        return title;
    }
}
