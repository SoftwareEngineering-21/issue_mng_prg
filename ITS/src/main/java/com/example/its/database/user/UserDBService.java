package com.example.its.database.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.User;
import com.example.its.dataClassDB.UserDB;

@Service
public class UserDBService {
    @Autowired
    private UserDBManager manager;

    //UserDB DTO to User DTO
    private User UDBtoUser(UserDB udb){
        User newU = new User(udb.getID());
        return newU;
    }

    // password decode
    public String hashedPW(String password){
        // #TODO try encode
        String encodePW = "tryencode";
        return encodePW;
    }

    public void createUserService(String ID, String password){
        //TODO 비밀번호 전처리
        manager.createUserManager(ID, password);
    }



}
