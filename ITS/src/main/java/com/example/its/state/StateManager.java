package com.example.its.state;

import com.example.its.dataClass.*;
import com.example.its.logic.authorityHandling.UserAuth;
import com.example.its.logic.authorityHandling.UserDeveloper;
import com.example.its.logic.authorityHandling.UserPlayer;
import com.example.its.logic.authorityHandling.UserTester;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class StateManager {

    private UserID user;
    private ProjectID project;
    private Authority authority;
    private IssueID issue;

}
