package com.example.its.dataClass;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Project {
	private final ProjectID projectID;
	private final String title;
	private final String description;
	private final UserID admin;

}
