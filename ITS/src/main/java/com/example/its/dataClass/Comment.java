package com.example.its.dataClass;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Comment {
	private final CommentID ID;
	private final String text;
	private final Timestamp date;
	private final UserID author;

}
