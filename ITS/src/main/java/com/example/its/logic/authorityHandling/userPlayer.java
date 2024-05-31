package com.example.its.logic.authorityHandling;


import com.example.its.dataClass.Issue;
import com.example.its.dataClass.UserID;

public class UserPlayer implements UserAuth {

    /**
     *
     * @param issue current issue
     * @param current current user
     * @param assignee assignee
     */
    @Override
    public boolean isAvailable(Issue issue, UserID current, UserID assignee) {
        if(issue == null){
            return false;
        }
        return issue.getStatus() == Issue.StatusID.NEW || issue.getStatus() == Issue.StatusID.RESOLVED || issue.getStatus() == Issue.StatusID.REOPENED;
    }

    @Override
    public void perform(Issue.StatusID state, Issue.PriorityID priority, Issue.TypeID type, UserID reporter, UserID assignee, UserID fixer) {

    }
}
