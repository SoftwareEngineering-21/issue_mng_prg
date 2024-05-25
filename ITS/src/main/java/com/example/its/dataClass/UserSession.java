package com.example.its.dataClass;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSession {
    private final String ID;
    private final String password;

}
