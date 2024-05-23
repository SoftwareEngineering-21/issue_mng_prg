package com.example.its.swingUI;

import com.example.its.dataClass.Project;

import java.util.ArrayList;

//GUI Test를 위한 testClass입니다
public class TestMainController extends MainController {
    public ArrayList<Project> projectList = new ArrayList<>();

    TestMainController(BaseController baseController){
        super(baseController);
        panel = new MainScenePanel(this);
        baseController.setPanel(panel);
    }

    @Override
    public Project[] getProjectList() {
        return projectList.toArray(new Project[projectList.size()]);
    }

    @Override
    public void oepnMakeProj() {
        if(makeProj == null){
            makeProj = new TestMakeCon(this);
        }

        makeProj.setVisible(true);
    }
}
