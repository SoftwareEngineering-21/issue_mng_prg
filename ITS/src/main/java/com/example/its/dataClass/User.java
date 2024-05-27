package com.example.its.dataClass;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {
	private final UserID ID;
	public User(String ID) {
		this.ID = new UserID(ID);
	}
}
