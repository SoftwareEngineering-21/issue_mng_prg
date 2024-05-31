package com.example.its.logic.authorityHandling;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Issue;
import com.example.its.dataClass.IssueID;
import com.example.its.dataClass.UserID;
import jdk.javadoc.doclet.Reporter;

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
    public void perform(Issue.StatusID status, Issue.PriorityID priority, Issue.TypeID type, UserID reporter, UserID assignee, UserID fixer);


}
