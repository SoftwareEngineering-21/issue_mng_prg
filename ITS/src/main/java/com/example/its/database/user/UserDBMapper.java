package com.example.its.database.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.its.dataClassDB.UserDB;

@Mapper
public interface UserDBMapper {
    public void createUser(UserDB user);
    public UserDB readUser(String ID);
    @Deprecated
    public void updateUser(@Param("ID") String ID, @Param("password") String password);
    public void deleteUser(String ID);

}
