package com.example.its.logic;

import com.example.its.dataClass.User;
import com.example.its.dataClass.UserID;
import com.example.its.dataClass.UserSession;
import com.example.its.database.user.UserDBService;
import com.example.its.status.StatusManager;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserDBService userDBService;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private String encodePW(String password){
        return passwordEncoder.encode(password);
    }

    // password decode
    private Boolean isMatch(String passwordDB, String inputPW){
        return passwordEncoder.matches(inputPW, passwordDB);
    }

    public void createUser(String ID, String password){

        userDBService.createUserService(ID,encodePW(password));
    }
    public void deleteUser(String ID){

    }
    public boolean validateUser(String ID){
        return isAvailable(new UserID(ID));
    }

    public boolean login(String ID, String password){
        UserID user = new UserID(ID);
        UserSession session = userDBService.readUserSessionService(user);
        if (session == null) return false;
        else{
            String EncodePW = session.getPassword();
            if(isMatch(EncodePW, password)){
                StatusManager.getInstance().setUser(new User(user.getID()));

                return true;
            }
            else return false;
        }
    }

    private boolean isAvailable(UserID newUser){
        User user = userDBService.readUserService(newUser);
        if(user == null){
            return true;
        }
        return false;
    }



}
