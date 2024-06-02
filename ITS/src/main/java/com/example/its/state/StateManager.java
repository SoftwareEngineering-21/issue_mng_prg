package com.example.its.state;

import java.util.List;

import com.example.its.dataClass.*;
import org.springframework.stereotype.Component;

import com.example.its.logic.authorityHandling.userAuth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class StateManager {

    private UserID user;
    private ProjectID project;
    private Authority authority;
    private IssueID issue;
    private CommentID comment;
    private List<userAuth> userAuthes;

}
