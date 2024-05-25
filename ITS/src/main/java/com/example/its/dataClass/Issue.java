package com.example.its.dataClass;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Issue {
	private final IssueID ID;
	private final String title;
	private final String description;
	private final int status;
	private final UserID assignee;
	private final UserID reporter;
	private final UserID fixer;
	private final int priority;

}
