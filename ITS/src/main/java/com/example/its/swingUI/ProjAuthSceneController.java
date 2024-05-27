package com.example.its.swingUI;

import com.example.its.dataClass.User;

public abstract class ProjAuthSceneController {
    public abstract void addTester(User id);
    public abstract void addPlayer(User id);
    public abstract void addDeveloper(User id);

    public abstract User[] getTesterList();
    public abstract User[] getPlayerList();
    public abstract User[] getDeveloperList();
}
