package com.example.its.dataClass;

public class Issue {
	private IssueID ID;
	private String title;
	private String description;
	private int status;
	private User assignee;
	private User reporter;
	private User fixer;
	private int priority;
	private Comment[] comments;

	public class IssueID{
		private int id;
	}
}
