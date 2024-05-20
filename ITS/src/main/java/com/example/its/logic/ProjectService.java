package com.example.its.logic;

import com.example.its.dataClass.*;
import com.example.its.database.project.ProjectDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectDBService service;

	public void createProject(User ID, String title, String description) {

		service.createProjectService(title,description,ID);
	}

	public void readProject(User ID) {}


}