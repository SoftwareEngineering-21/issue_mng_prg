package com.example.its.dataClass;

public class Comment {
	private CommentID ID;
	private Issue.IssueID issueID;
	private String text;
	private Date date;
	private User author;

	private class CommentID {
		private int ID;

		public int getCommentID() {
			return ID;
		}
	}

	private class Date {
		private String time;

		public String getTime() {
			return time;
		}
	}

	public int readID(){
		return ID.getCommentID();
	}

	public String readTime() {
		return date.getTime();
	}
}
