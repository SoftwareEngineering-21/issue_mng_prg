package com.example.its.swingUI;

import java.util.ArrayList;

public class TestController implements SwingController {
    SwingGUI gui;
    ArrayList<Project> projectList = new ArrayList<>();

    public TestController(){
        gui = new SwingGUI(this);
        gui.setVisible(true);
    }

    @Override
    public ArrayList<Project> getProjectList() {
        return projectList;
    }

    @Override
    public void makeNewProject(String title, String decs) {
        Project newProject = new Project(projectList.size(), title, decs);
        projectList.add(newProject);
        System.out.println(projectList.size());

        gui.repaint();
    }
    
}
