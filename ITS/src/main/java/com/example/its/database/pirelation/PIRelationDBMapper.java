package com.example.its.database.pirelation;

import org.apache.ibatis.annotations.Mapper;

import com.example.its.dataClassDB.PIRelationDB;

@Mapper
public interface PIRelationDBMapper {
    Integer createPIRelation(PIRelationDB pIRelation);
}