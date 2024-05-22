package com.example.its.dataClass;

import java.util.EnumSet;

public class Authority{
    public enum AuthorityID{ PLAYER, DEVELOPER, TESTER}
    public EnumSet<AuthorityID> authority = EnumSet.noneOf(AuthorityID.class);


}
