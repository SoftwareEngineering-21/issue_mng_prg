package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDB {
    private String ID;
    private String pw;

    public UserDB(String ID, String pw)
    {
        this.ID = ID;
        this.pw = pw;
    }


}
