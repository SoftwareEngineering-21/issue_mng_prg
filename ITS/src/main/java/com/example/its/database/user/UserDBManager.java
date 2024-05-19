package com.example.its.database.user;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.example.its.dataClassDB.UserDB;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDBManager {
    private final UserDBMapper userDB;

    @Async
    public void createUserManager(String id, String pw){
        synchronized (this){
            UserDB new_user = new UserDB(id, pw);
            userDB.createUser(new_user);
        }
    }

    @Async
    public CompletableFuture<UserDB> readUserManager(String id){
        synchronized (this){
            return CompletableFuture.completedFuture(userDB.readUser(id));
        }
    }

    @Async
    public void updateUserManager(String pw){
        synchronized (this) {
            
        }
    }


    @Async
    public void deleteUserManager(String id){
        synchronized (this){
            userDB.deleteUser(id);
        }
    }
}
