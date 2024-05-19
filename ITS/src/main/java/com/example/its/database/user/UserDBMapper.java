package com.example.its.database.user;

import org.apache.ibatis.annotations.Mapper;

import com.example.its.dataClassDB.UserDB;

@Mapper
public interface UserDBMapper {
    public void createUser(UserDB user);
    public UserDB readUser(String ID);
    public void updateUser(String ID, String password);
    public void deleteUser(String ID);

}
