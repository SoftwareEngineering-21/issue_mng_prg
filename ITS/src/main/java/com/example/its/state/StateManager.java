package com.example.its.state;

import com.example.its.dataClass.*;
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
    private IssueID issue;

}
