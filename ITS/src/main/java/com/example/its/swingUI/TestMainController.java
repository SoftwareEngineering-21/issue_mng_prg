//package com.example.its.swingUI;
//
//import com.example.its.dataClass.Project;
//
//import java.util.ArrayList;
//
////GUI Test를 위한 testClass입니다
//public class TestMainController extends MainController {
//    public ArrayList<Project> projectList = new ArrayList<>();
//
//    TestMainController(BaseController baseController){
//        super(baseController);
//        projCon = new TestProjCon(this.baseController);
//
//        panel.makeProjectList();
//        setBasePanel();
//    }
//
//    @Override
//    public Project[] getProjectList() {
//        if(projectList == null){
//            return null;
//        }
//
//        return projectList.toArray(new Project[projectList.size()]);
//    }
//
//    @Override
//    public void openMakeProj() {
//        if(makeProjCon == null){
//            makeProjCon = new TestMakeCon(this);
//        }
//
//        makeProjCon.setVisible(true);
//    }
//
//    @Override
//    public void openProject(int index) {
//        if(projectList.size() <= index){
//            //Error
//            return;
//        }
//
//        projCon.setProjPanel(projectList.get(index));
//    }
//}
