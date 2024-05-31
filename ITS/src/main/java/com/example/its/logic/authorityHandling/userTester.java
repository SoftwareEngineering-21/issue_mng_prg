package com.example.its.logic.authorityHandling;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.UserID;

public class UserTester implements UserAuth {

    /**
     *
     * @param issue current issue // if create, issue= null
     * @param current current user
     * @param assignee assignee
     */
    @Override
    public boolean isAvailable(Issue issue, UserID current, UserID assignee) {
        if(issue == null || issue.getStatus() == Issue.StatusID.FIXED){
            return true;
        }
        return false;
    }

    @Override
    public void perform(Issue.StatusID state, Issue.PriorityID priority, Issue.TypeID type, UserID reporter, UserID assignee, UserID fixer) {

    }
}
