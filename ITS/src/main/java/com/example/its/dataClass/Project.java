package com.example.its.dataClass;

public class Project {
	private projectID ID;
	private String title;
	private String description;
	private String admin;

	private class projectID {
		private int projectID;

		public int getProjectID() {
			return projectID;
		}
	}

	public int readID() {
		return ID.getProjectID();
	}
}
