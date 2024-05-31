package com.example.its.state;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class StateManager {

    private UserID user;
    private ProjectID project;
    private Authority authority;
    private Issue issue;

}
