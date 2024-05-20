package com.example.its.dataClassDB;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDB {
    private String ID;
    private String password;

    public UserDB(String ID, String password)
    {
        this.ID = ID;
        this.password = password;
    }


}
