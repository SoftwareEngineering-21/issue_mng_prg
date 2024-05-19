package com.example.its.database.user;

import org.apache.ibatis.annotations.Mapper;

import com.example.its.dataClassDB.UserDB;

@Mapper
public interface UserDBMapper {
    public void createUser(UserDB user);
    public UserDB readUser(String id);
    public void updateUser(String id, String pw);
    public void deleteUser(String id);

}
