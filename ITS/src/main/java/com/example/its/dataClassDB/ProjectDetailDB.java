package com.example.its.dataClassDB;

public class ProjectDetailDB {
    private int id;
    private String title;
    private String description;
    private String adminId;

    public ProjectDetailDB(String title, String description, String adminId)
    {
        this.id =
id;
        this.title = title;
        this.description = description;
        this.adminId = adminId;
    }

public int readId() {return this.id;}
public String readTitle() {return this.title;}
public String readDescription() {return this.description;}
public String readAdminId() {return this.adminId;}

public void updateId(int id) {this.id=id;}
public void updateTitle(String title) {this.title=title;}
public void updateDescription(String description) {this.description=description;}
public void updateadminId(String adminId) {this.adminId=adminId;}

}