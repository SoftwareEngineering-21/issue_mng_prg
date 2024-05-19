package com.example.its.dataClass;

import lombok.Getter;

@Getter
public class Comment {
	private CommentID ID;
	private IssueID issueID;
	private String text;
	private Date date;
	private User author;



	private class Date {
		private String time;

		public String getTime() {
			return time;
		}
	}

}
