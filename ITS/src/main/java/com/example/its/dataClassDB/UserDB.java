package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDB {
    private String id;
    private String pw;

    public UserDB(String id, String pw)
    {
        this.id = id;
        this.pw = pw;
    }


}
