package com.example.its.database.user;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.its.dataClassDB.UserDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDBManager {
    private final UserDBMapper userDB;

    @Async
    public void createUserManager(String ID, String password){
        synchronized (this){
            UserDB new_user = new UserDB(ID, password);
            userDB.createUser(new_user);
        }
    }

    @Async
    public CompletableFuture<UserDB> readUserManager(String ID){
        synchronized (this){
            return CompletableFuture.completedFuture(userDB.readUser(ID));
        }
    }

    @Async
    public void updateUserManager(String ID, String password){
        synchronized (this) {
            userDB.updateUser(ID, password);
        }
    }


    @Async
    public void deleteUserManager(String ID){
        synchronized (this){
            userDB.deleteUser(ID);
        }
    }
}