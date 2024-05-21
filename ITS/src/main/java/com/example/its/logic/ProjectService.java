package com.example.its.logic;

import com.example.its.dataClass.*;
import com.example.its.database.project.ProjectDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

	private final ProjectDBService service;

	public void createProject(UserID ID, String title, String description) {
		service.createProjectService(title,description,ID);
	}

	public List<Project> readProjectList(UserID ID) {
        return service.readProjectListService(ID);
    }

	public Project readProject(ProjectID ID) {
		return service.readProjectService(ID);
	}

}