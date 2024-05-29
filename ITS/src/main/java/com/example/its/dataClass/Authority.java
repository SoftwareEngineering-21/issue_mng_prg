package com.example.its.dataClass;

import lombok.Getter;

import java.util.EnumSet;
@Getter
public class Authority{
    public enum AuthorityID{ PLAYER, DEVELOPER, TESTER}
    public EnumSet<AuthorityID> authority = EnumSet.noneOf(AuthorityID.class);

    public void addAuthority(AuthorityID authorityID){
        authority.add(authorityID);
    }
    public void removeAuthority(AuthorityID authorityID){authority.remove(authorityID);}
    public void resetAuthority(){authority.clear();}

}
