package com.example.its.logic;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.dataClass.UserSession;
import com.example.its.database.DBService;
import com.example.its.logic.encoder.Encryptor;
import com.example.its.logic.Exception.LoginFailureException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{

    private final DBService service;


    private final Encryptor passwordEncoder;
    private String encodePW(String password){
        return passwordEncoder.encode(password);
    }

    // password decode
    private Boolean isMatch(String passwordDB, String inputPW){
        return passwordEncoder.matches(inputPW, passwordDB);
    }

    public void createUser(String ID, String password){
        service.createUser(ID, encodePW(password));
    }
    public void deleteUser(String ID){

    }
    public boolean validateUser(String ID){
        return isAvailable(new UserID(ID));
    }


    public UserID login(String ID, String password) throws LoginFailureException {
        UserID user = new UserID(ID);
        UserSession session = service.readUserSession(user);
        if (session == null) throw new LoginFailureException();
        else{
            String EncodePW = session.getPassword();
            if(isMatch(EncodePW, password)){
                
                return user;
            }
            throw new LoginFailureException();
        }
    }

    private boolean isAvailable(UserID newUser){
        User user = service.readUser(newUser);
        return user == null;
    }
}
