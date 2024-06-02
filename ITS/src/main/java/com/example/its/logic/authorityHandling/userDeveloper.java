package com.example.its.logic.authorityHandling;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.UserID;

public class userDeveloper implements userAuth {

    @Override
    public boolean isAvailable(Issue issue, UserID current, UserID assignee) {
        if(issue==null){
            return false;
        }
        return issue.getStatus() == Issue.StatusID.ASSIGNED;
    }

    @Override
    public Issue perform(Issue.StatusID state, Issue.PriorityID priority, Issue.TypeID type, UserID reporter, UserID assignee, UserID fixer) {
        Issue i = new Issue(null, null, null, Issue.StatusID.FIXED, type, priority, assignee, reporter, fixer);
        return i;
        
    }
}
