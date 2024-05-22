package com.example.its.swingUI;

import java.util.ArrayList;

import com.example.its.dataClass.User;

public class TestProjAuthController implements ProjAuthController {
    ArrayList<User> testerList = new ArrayList<>();
    ArrayList<User> playerList = new ArrayList<>();
    ArrayList<User> developerList = new ArrayList<>();

    @Override
    public void addTester(User id) {
        testerList.add(id);
    }

    @Override
    public void addPlayer(User id) {
        playerList.add(id);
    }

    @Override
    public void addDeveloper(User id) {
        playerList.add(id);
    }

    @Override
    public User[] getTesterList() {
        return (User[])testerList.toArray();
    }

    @Override
    public User[] getPlayerList() {
        return (User[])playerList.toArray();
    }

    @Override
    public User[] getDeveloperList() {
        return (User[])developerList.toArray();
    }
}