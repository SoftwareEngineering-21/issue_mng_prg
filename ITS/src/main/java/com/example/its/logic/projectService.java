package com.example.its.logic;

import com.example.its.dataClass.*;

public class projectService {
	void createProject(User ID, String projectName, String description) {
		Project newProject = new Project();
		newProject.setTitle(projectName);
		newProject.setDescription(description);
		newProject.setAdmin(ID);
		//DB 측에 생성 요청 - return값 = projectID?
	}
}