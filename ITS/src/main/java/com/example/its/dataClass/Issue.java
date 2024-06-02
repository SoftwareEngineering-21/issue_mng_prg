package com.example.its.dataClass;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Issue {
	public enum TypeID {BUG, IMPROVEMENT, NEW_FEATURE, TASK, STORY};
	public enum PriorityID {BLOCKER, CRITICAL, MAJOR, MINOR, TRIVIAL};
	public enum StatusID {NEW, ASSIGNED, FIXED, RESOLVED, REOPENED, CLOSED};


	private final IssueID ID;
	private final String title;
	private final String description;
	private final StatusID status;
	private final TypeID type;
	private final PriorityID priority;



	private final UserID assignee;
	private final UserID reporter;
	private final UserID fixer;


}
