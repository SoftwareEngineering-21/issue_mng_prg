package com.example.its.dataClass;

public class Comment {
	private CommentID ID;
	private Issue.IssueID issueID;
	private String text;
	private Date date;
	private User author;

	private class CommentID {
		private int ID;
	}
}
