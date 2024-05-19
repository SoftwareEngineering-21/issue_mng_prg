package com.example.its.swingUI;

import com.example.its.dataClassDB.ProjectDB;

import java.util.ArrayList;

//GUI Test를 위한 testClass입니다
public class TestController implements ProjectController {
    SwingGUI gui;
    ArrayList<ProjectDB> projectList = new ArrayList<>();

    public TestController(){
        gui = new SwingGUI(this);
        gui.setVisible(true);
    }

    @Override
    public ArrayList<ProjectDB> getProjectList() {
        return projectList;
    }

    @Override
    public void makeNewProject(String title, String decs) {
        ProjectDB newProject = new ProjectDB( title, decs, "Admin");
        projectList.add(newProject);
        System.out.println(projectList.size());

        gui.repaint();
    }
    
}
