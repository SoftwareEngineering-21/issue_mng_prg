package com.example.its.swingUI;

import com.example.its.dataClass.Project;

import java.util.ArrayList;

//GUI Test를 위한 testClass입니다
public class TestMainController implements MainController {
    MakeProjectFrame makeProj;
    ArrayList<Project> projectList = new ArrayList<>();

    @Override
    public Project[] getProjectList() {
        return (Project[])projectList.toArray();
    }

    @Override
    public void oepnMakeProj() {
        if(makeProj == null){
            //makeProj = new MakeProjectFrame();
        }

        makeProj.setVisible(true);
    }
}
