package com.example.its.status;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusManager {
    private static StatusManager instance;
    public static StatusManager getInstance() {
        if(instance == null) {
             instance= new StatusManager();
        }
        return instance;
    }
    private UserID user;
    private ProjectID project;
    private Authority authority;
    private Issue issue;

}
