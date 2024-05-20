package com.example.its.dataClass;


import lombok.Getter;

@Getter
public class Issue {
	private IssueID ID;
	private String title;
	private String description;
	private int status;
	private UserID assignee;
	private UserID reporter;
	private UserID fixer;
	private int priority;

}
