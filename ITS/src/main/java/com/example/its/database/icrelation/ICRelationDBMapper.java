package com.example.its.database.icrelation;

import org.apache.ibatis.annotations.Mapper;

import com.example.its.dataClassDB.ICRelationDB;

@Mapper
public interface ICRelationDBMapper {
    Integer createICRelation(ICRelationDB icrelation);
    
}
