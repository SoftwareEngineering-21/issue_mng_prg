package com.example.its.swingUI;

import com.example.its.dataClass.User;

public interface ProjAuthController {
    public void addTester(User id);
    public void addPlayer(User id);
    public void addDeveloper(User id);

    public User[] getTesterList();
    public User[] getPlayerList();
    public User[] getDeveloperList();
}
