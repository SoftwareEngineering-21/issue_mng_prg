package com.example.its.dataClass;

import java.sql.Timestamp;

import lombok.Getter;

@Getter
public class Comment {
	private CommentID ID;
	private String text;
	private Timestamp date;
	private UserID author;

}
