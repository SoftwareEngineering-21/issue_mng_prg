package com.example.its.swingUI;

import java.util.ArrayList;

import com.example.its.dataClassDB.ProjectDetailDB;

//GUI Test를 위한 testClass입니다
public class TestController implements SwingController {
    SwingGUI gui;
    ArrayList<ProjectDetailDB> projectList = new ArrayList<>();

    public TestController(){
        gui = new SwingGUI(this);
        gui.setVisible(true);
    }

    @Override
    public ArrayList<ProjectDetailDB> getProjectList() {
        return projectList;
    }

    @Override
    public void makeNewProject(String title, String decs) {
        ProjectDetailDB newProject = new ProjectDetailDB(projectList.size(), title, decs, "Admin");
        projectList.add(newProject);
        System.out.println(projectList.size());

        gui.repaint();
    }
    
}
