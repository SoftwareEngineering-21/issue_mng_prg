package com.example.its.logic;

import com.example.its.dataClass.*;
import com.example.its.database.DBService;
import com.example.its.database.project.ProjectDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectService {

	private final DBService service;

	public void createProject(UserID ID, String title, String description) {
		service.createProject(title,description,ID);
	}

	public List<Project> readProjects(UserID ID) {
        return service.readProjectList(ID);
    }

	public List<Project> readAdminProjects(UserID ID) {
		return service.readAdminProjectList(ID);
	}

	public Project readProject(ProjectID projectID) {
		return service.readProject(projectID);
	}


}