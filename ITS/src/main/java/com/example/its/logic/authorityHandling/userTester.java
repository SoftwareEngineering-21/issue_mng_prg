package com.example.its.logic.authorityHandling;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.UserID;

public class userTester implements userAuth {

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
    public Issue perform(Issue.StatusID state, Issue.PriorityID priority, Issue.TypeID type, UserID reporter, UserID assignee, UserID fixer) {
        if (state == null){
            Issue i = new Issue(null, null, null, Issue.StatusID.NEW, type, priority, assignee, reporter, fixer);
            return i;
        }
        else{
            //fix -> resolve or reopen
            if(state == Issue.StatusID.RESOLVED){
                Issue i = new Issue(null, null, null, state, type, priority, assignee, reporter, fixer);
                return i;
            }
            else{
                //reopen 일 때 fixer null로 반환
                Issue i = new Issue(null, null, null, state, type, priority, assignee, reporter, null);
                return i;
            }
        }
    }
}
