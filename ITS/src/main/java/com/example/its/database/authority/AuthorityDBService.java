package com.example.its.database.authority;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.dataClass.Authority;
import com.example.its.dataClass.Authority.AuthorityID;
import com.example.its.dataClass.ProjectID;
import com.example.its.dataClass.UserID;
import com.example.its.dataClassDB.AuthorityDB;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorityDBService {
    private final AuthorityDBManager manager;

    // create authority
    public void createAuthorityService(UserID userID, ProjectID projectID, int auth){
        manager.createAuthorityManager(userID.getID(), projectID.getID(), auth);
    }

    // read authority by project
    public List<List<UserID>> readAuthorityListbyProjectService(ProjectID projectID){
        List<List<UserID>> nowAllAuthList = new ArrayList<>();
        List<UserID> nowAuthList0 = new ArrayList<>();
        List<UserID> nowAuthList1 = new ArrayList<>();
        List<UserID> nowAuthList2 = new ArrayList<>();
        List<AuthorityDB> authList = manager.readAuthorityListbyProjectManager(projectID.getID());
        for (AuthorityDB auth : authList){
            switch (auth.getAuth()){
                case 0:
                    nowAuthList0.add(new UserID(auth.getUserID()));
                    break;
                case 1:
                    nowAuthList1.add(new UserID(auth.getUserID()));
                    break;
                case 2:
                    nowAuthList2.add(new UserID(auth.getUserID()));
                    break;



            }
        }
        nowAllAuthList.add(nowAuthList0);
        nowAllAuthList.add(nowAuthList1);
        nowAllAuthList.add(nowAuthList2);

        return nowAllAuthList;
    }

    //projectID 랑 userID 로 read
    public Authority readAuthorityListbyAllService(UserID userID, ProjectID projectID){
        Authority authEnumSet = new Authority();
        List<AuthorityDB> authList = manager.readAuthorityListbyAllManager(userID.getID() ,projectID.getID());
        for (AuthorityDB auth : authList){
            switch(auth.getAuth()) {
                case 0:
                    authEnumSet.authority.add(AuthorityID.PLAYER);
                    break;
                case 1:
                    authEnumSet.authority.add(AuthorityID.DEVELOPER);
                    break;
                case 2:
                    authEnumSet.authority.add(AuthorityID.TESTER);
                    break;
            }
        }
        return authEnumSet;

    }
    
    //delete auth
    public void deleteAuthority(UserID userID, ProjectID projectID, int auth){
        manager.deleteAuthorityManager(userID.getID(), projectID.getID(), auth);
    }

}
