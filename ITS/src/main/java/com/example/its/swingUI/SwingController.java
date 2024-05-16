package com.example.its.swingUI;

import java.util.ArrayList;

public interface SwingController {
    ArrayList<Project> getProjectList();
    void makeNewProject(String title, String decs);
}