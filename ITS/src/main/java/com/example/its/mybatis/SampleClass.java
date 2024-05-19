package com.example.its.mybatis;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class SampleClass {

    public  List<SampleDTO> sampleDTOList;

    private final Sample sample;

    @Async
    public CompletableFuture<List<SampleDTO>> selectTestList(){
        return CompletableFuture.completedFuture(sample.selectTest());
    }
    @Async
    public void test1(){
        try {
            sampleDTOList = selectTestList().get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int size = sampleDTOList.size();
        System.out.println("test용"+size);
        int i =0;
        for(i= 0; i<size ; i++){
            System.out.println(sampleDTOList.get(i).getIdtset());
        }
    }




}
