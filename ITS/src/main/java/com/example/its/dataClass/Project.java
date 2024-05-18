package com.example.its.dataClass;

public class Project {
	private projectID ID;
	private String title;
	private String description;
	private User admin;

	private class projectID {
		private int projectID;

		private int getProjectID() {
			return projectID;
		}
		private void setProjectID(int ID) {
			this.projectID = ID;
		}
	}

	public int readID() {
		return ID.getProjectID();
	}

	public void setID(int projectID) {
		this.ID = new projectID();
		this.ID.setProjectID(projectID);
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setAdmin(User user) {
		this.admin = user;
	}
}
