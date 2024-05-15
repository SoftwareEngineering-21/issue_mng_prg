package com.example.its.dataClassDB;

public class UserDB {
    private String id;
    private String pw;

    public UserDB(String id, String pw)
    {
        this.id = id;
        this.pw = pw;
    }

    public String readId() {return this.id;}
    public String readPw() {return this.pw;}
    public void updateId(String id) {this.id=id;}
    public void updatePw(String pw) {this.pw=pw;}


}
