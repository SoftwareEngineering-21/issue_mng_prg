package com.example.its.database.user;

import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.UserDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDBManager {
    private final UserDBMapper userDB;

    public void createUserManager(String ID, String password){
            UserDB new_user = new UserDB(ID, password);
            userDB.createUser(new_user);
    }

    public UserDB readUserManager(String ID){
        return userDB.readUser(ID);
    }

    @Deprecated
    public void updateUserManager(String ID, String password){
        userDB.updateUser(ID, password);
    }

    public void deleteUserManager(String ID){
        userDB.deleteUser(ID);
    }
}
