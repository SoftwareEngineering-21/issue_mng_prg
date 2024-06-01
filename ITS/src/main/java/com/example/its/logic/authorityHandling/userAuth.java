package com.example.its.logic.authorityHandling;

import com.example.its.dataClass.Issue;
import com.example.its.dataClass.UserID;

public interface userAuth {
    /**
     *
     * @param issue current issue
     * @param current current user
     * @param assignee assignee
     */
    public boolean isAvailable(Issue issue,UserID current, UserID assignee);

    /**
     *
     * @param status st
     * @param priority pr
     * @param type ty
     * @param reporter rep
     * @param assignee assign
     * @param fixer fix
     */
    public Issue perform(Issue.StatusID status, Issue.PriorityID priority, Issue.TypeID type, UserID reporter, UserID assignee, UserID fixer);


}
