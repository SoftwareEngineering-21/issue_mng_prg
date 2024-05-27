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
    public Boolean checkRightPWService(UserID userID, String inputPW){

            UserDB currentUserDB = manager.readUserManager(userID.getID());
            if(currentUserDB == null){
                System.out.println("user id is not exist");
                return false;
            }
            // TODO id & pw맞는거 없으면 customized error 반환
            if (decodePW(currentUserDB.getPassword(), inputPW)){return true;}
            else {
                System.out.println("pw is not correct");
                return false;
            }

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


    //update user's password
    public void updateUserService(UserID userID, String password, String newPW){
        if(checkRightPWService(userID, newPW)){
            manager.updateUserManager(userID.getID(), encodePW(newPW));
        }
    }

    //delete user
    public void deleteUserSerivce(UserID userID){
        manager.deleteUserManager(userID.getID());
    }
}
