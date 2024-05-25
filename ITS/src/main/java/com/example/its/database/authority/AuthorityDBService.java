package com.example.its.database.authority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.dataClassDB.AuthorityDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityDBService {
    private final AuthorityDBManager manager;
    
    //TODO 필요 없으면 지우기
    private AuthorityDB getAuthority(int ID){
        return manager.readAuthorityManager(ID);
    }

    // create authority
    public int createAuthorityService(String userID, int projectID, int auth){
        return manager.createAuthorityManager(userID, projectID, auth);
    }

    // read authority by project
    public HashMap<String, List<Integer>> readAuthorityListbyProjectService(ProjectID projectID){
        HashMap<String, List<Integer>> authMap = new HashMap<String, List<Integer>>();
        List<AuthorityDB> authList = manager.readAuthorityListbyProjectManager(projectID.getID());
        for (AuthorityDB auth : authList){
            boolean flag = true;
            for(String key : authMap.keySet()){
                
                if (key.equals(auth.getUserID())){
                    List<Integer> temp = authMap.get(key);
                    temp.add(auth.getAuth());
                    temp.sort((a, b) ->a - b);
                    authMap.put(key, temp);
                    flag= false;
                    break;
                }
            }
            if(flag){
                List<Integer> temp = new ArrayList<>();
                temp.add(auth.getAuth());
                authMap.put(auth.getUserID(), temp);
            }
        }
        return authMap;
    }

    //read authority by user
    public HashMap<Integer, List<Integer>> readAuthorityListbyUserService(UserID userID){
        HashMap<Integer, List<Integer>> authMap = new HashMap<Integer, List<Integer>>();
        List<AuthorityDB> authList = manager.readAuthorityListbyUserManager(userID.getID());
        
        for (AuthorityDB auth : authList){
            boolean flag = true;
            for(Integer key : authMap.keySet()){
                
                if (key.equals(auth.getProjectID())){
                    List<Integer> temp = authMap.get(key);
                    temp.add(auth.getAuth());
                    temp.sort((a, b) ->a - b);
                    authMap.put(key, temp);
                    flag= false;
                    break;
                }
            }
            if(flag){
                List<Integer> temp = new ArrayList<>();
                temp.add(auth.getAuth());
                authMap.put(auth.getProjectID(), temp);
            }
        }
        return authMap;
    }
    
    //delete auth
    public void deleteAuthority(int ID){
        manager.deleteAuthorityManager(ID);
    }

}
