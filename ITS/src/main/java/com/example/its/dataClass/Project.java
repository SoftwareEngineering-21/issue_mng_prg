package com.example.its.dataClass;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Project {
	private final ProjectID ID;
	private final String title;
	private final String description;
	private final User admin;




}
