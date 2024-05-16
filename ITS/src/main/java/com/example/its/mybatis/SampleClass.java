package com.example.its.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SampleClass {
    private final Sample sample;

    public List<SampleDTO> selectTestList(){
        return sample.selectTest();
    }

}
