package com.example.its.database.user;

import com.example.its.dataClass.UserSession;
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
    @Autowired //밑에 final 로 만들고 지우기?
    private final UserDBManager manager;

    //UserDB DTO to User DTO
    private User UDBtoUser(UserDB udb){
        User newU = new User(new UserID(udb.getID()));
        return newU;
    }



    //create User, 중복 겁사는 UI단에서?????
    public UserID createUserService(String ID, String password){
        //String encodedPW = encodePW(password);
        manager.createUserManager(ID, password);
        User returnID = readUserService(new UserID(ID));
        return returnID.getID();
    }

    // read user
    public User readUserService(UserID user){
        UserDB rudb = manager.readUserManager(user.getID());
        if(rudb == null){ return null;}
        return UDBtoUser(rudb);
    }

    public UserSession readUserSessionService(UserID user){
        UserDB rudb = manager.readUserManager(user.getID());
        if(rudb == null){ return null;}
        return new UserSession(rudb.getID(), rudb.getPassword());
    }




    //delete user
    public void deleteUserSerivce(UserID userID){
        manager.deleteUserManager(userID.getID());
    }
}
