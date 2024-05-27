package com.example.its.test;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface Sample {
    List<SampleDTO> selectTest();
}
