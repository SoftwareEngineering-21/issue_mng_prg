package com.example.its.swingUI;

import java.util.ArrayList;

import com.example.its.dataClassDB.ProjectDetailDB;

//MainScene을 위한 기능이 담긴 interface입니다. 추후에 다른 이름으로 수정될 수 있습니다.
public interface SwingController {
    ArrayList<ProjectDetailDB> getProjectList();
    void makeNewProject(String title, String decs);
}