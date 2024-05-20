package com.example.its.dataClass;


import lombok.Getter;

@Getter
public class Issue {
	private IssueID ID;
	private String title;
	private String description;
	private int status;
	private User assignee;
	private User reporter;
	private User fixer;
	private int priority;
	//TODO 이것도 ID 통해서 DB로 검색할 수 있을 것 같은데 불필요한 정보 아닌지 확인해볼 것
	private Comment[] comments;



}
