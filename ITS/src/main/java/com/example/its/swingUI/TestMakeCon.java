package com.example.its.swingUI;

import com.example.its.dataClass.Project;

public class TestMakeCon extends MakeProjectController {
    TestMainController controller;

    TestMakeCon(MainController controller) {
        super(controller);
        frame.setVisible(true);
    }

    TestMakeCon(TestMainController controller) {
        super(controller);
        this.controller = controller;
        frame.setVisible(true);
    }
    
    @Override
    public void makeNewProject(String title, String Desc) {
        System.out.println(title + " : " + Desc);
        controller.projectList.add(new Project(null, title, Desc, null));
        controller.panel.makeProjectList();
    }

    @Override
    public void setVisible(boolean isVisible) {
        frame.setVisible(isVisible);
    }
}
