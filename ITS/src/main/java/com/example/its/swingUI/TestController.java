package com.example.its.swingUI;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.User;

import java.util.ArrayList;

//GUI Test를 위한 testClass입니다
public class TestController implements ProjectController {
    User user;
    SwingGUI gui;
    ArrayList<Project> projectList = new ArrayList<>();

    public TestController(){
        user = new User("123");
        gui = new SwingGUI(this);
        gui.setVisible(true);
    }

    @Override
    public ArrayList<Project> getProjectList() {
        return projectList;
    }

    @Override
    public void makeNewProject(String title, String decs) {
        Project newProject = new Project(new ProjectID(projectList.size()), title, decs, user);
        projectList.add(newProject);
        //System.out.println(projectList.size());

        gui.repaint();
    }

    @Override
    public ArrayList<User> getTesterList() {
        return new ArrayList<User>();
    }

    @Override
    public ArrayList<User> getPlayerList() {
        return new ArrayList<User>();
    }

    @Override
    public ArrayList<User> getDeveloperList() {
        return new ArrayList<User>();
    }
    
}
