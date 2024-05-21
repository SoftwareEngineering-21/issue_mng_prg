package com.example.its.database.user;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.dataClassDB.UserDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDBService {
    @Autowired
    private UserDBManager manager;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //UserDB DTO to User DTO
    private User UDBtoUser(UserDB udb){
        User newU = new User(new UserID(udb.getID()));
        return newU;
    }

    // password encode
    private String encodePW(String password){
        String encryptedPassword = passwordEncoder.encode(password);
        return encryptedPassword;
    }

    // password decode
    private Boolean decodePW(String passwordDB, String inputPW){
        boolean isPasswordMatch = passwordEncoder.matches(inputPW, passwordDB);
        return isPasswordMatch;
    }

    //id pw check
    public Boolean checkRightPW(UserID userID, String inputPW){
            try {
                CompletableFuture<UserDB> udb = manager.readUserManager(userID.getID());
                UserDB currentUserDB;
                currentUserDB = udb.get();
                if(currentUserDB == null){
                    System.out.println("user id is not exist");
                    return false;
                }
                // TODO id & pw맞는거 없으면 customized error 반환
                if (decodePW(currentUserDB.getPassword(), inputPW)){return true;}
                else {
                    System.out.println("pw is not correct");
                    return false;}
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
    }

    //create User
    public void createUserService(String ID, String password){
        String encodedPW = encodePW(password);
        manager.createUserManager(ID, encodedPW);
    }

    // read user
    public User readUserService(UserID user){
        CompletableFuture<UserDB> udb = manager.readUserManager(user.getID());
        try {
            UserDB rudb = udb.get();
            return UDBtoUser(rudb);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    //update user's password
    public void updateUserService(UserID userID, String password, String newPW){
        if(checkRightPW(userID, newPW)){
            manager.updateUserManager(userID.getID(), encodePW(newPW));
        }
    }

    //delete user
    public void deleteUserSerivce(UserID userID){
        manager.deleteUserManager(userID.getID());
    }

}
