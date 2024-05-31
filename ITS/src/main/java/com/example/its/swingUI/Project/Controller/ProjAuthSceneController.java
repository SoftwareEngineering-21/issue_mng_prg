package com.example.its.swingUI.Project.Controller;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.swingUI.BaseController;
import com.example.its.swingUI.Project.ProjectAuthPanel;

public class ProjAuthSceneController {
    BaseController baseController;

    UserID[] testers;
    UserID[] players;
    UserID[] developers;

    ProjectAuthPanel panel;

    ProjAuthSceneController(BaseController baseController){
        this.baseController = baseController;

        this.panel = new ProjectAuthPanel(this);
    }

    public boolean addTester(String id){
        return baseController.addTester(new UserID(id));
    }

    public boolean addPlayer(String id){
        return baseController.addPlayer(new UserID(id));
    }   

    public boolean addDeveloper(String id){
        return baseController.addDeveloper(new UserID(id));
    }

    public UserID[] getTesterList(){
        this.testers = baseController.getTesterList();
        return this.testers;
    }

    public UserID[] getPlayerList(){
        this.players = baseController.getPlayerList();
        return this.players;
    }

    public UserID[] getDeveloperList(){
        this.developers = baseController.getDeveloperList();;
        return this.developers;
    }

    public boolean deleteTester(int index){
        if(testers == null || testers.length <= index){
            return false;
        }
        boolean result = this.baseController.deleteTester(testers[index]);
        this.panel.setTesterList();

        return result;
    }

    public boolean deletePlayer(int index){
        if(players == null || players.length <= index){
            return false;
        }
        boolean result = this.baseController.deletePlayer(players[index]);
        this.panel.setPlayerList();

        return result;
    }

    public boolean deleteDeveloper(int index){
        if(developers == null || developers.length <= index){
            return false;
        }
        boolean result = this.baseController.deleteDeveloper(developers[index]);
        this.panel.setDeveloperList();
        
        return result;
    }

    public void run(){
        this.panel.setList();
        this.baseController.setBasePanel(panel);
    }
}
