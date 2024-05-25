package com.example.its.status;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.Project;
import com.example.its.dataClass.User;
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
    private User user;
    private Project project;
    private Authority authority;
    private Issue issue;

}
