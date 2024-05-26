package com.example.its.swingUI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.its.dataClass.Project;
import com.example.its.dataClass.UserID;
import com.example.its.database.project.ProjectDBManager;
import com.example.its.database.project.ProjectDBService;
import com.example.its.logic.ProjectService;

@Controller
public class RealMainContr extends MainController {
    @Autowired
    ProjectService projectService;

    RealMainContr(BaseController baseController) {
        super(baseController);
    }

    RealMainContr(){
        super(new TestBaseCon());
    }

    @Override
    public Project[] getProjectList() {
        if(projectService == null){
            System.out.println("Error! projectService is null");
            return null;
        }

        List<Project> list = projectService.readProjects(new UserID("test"));
        return list.toArray(new Project[list.size()]);
    }

    @Override
    public void openMakeProj() {

    }

    @Override
    public void openProject(int index) {

    }
    
}
