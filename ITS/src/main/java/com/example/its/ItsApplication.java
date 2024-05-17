package com.example.its;

import com.example.its.mybatis.Sample;
import com.example.its.mybatis.SampleClass;
import com.example.its.mybatis.SampleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class ItsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ItsApplication.class, args);
    }

    @Autowired
    public  SampleClass sampleClass;

    public  List<SampleDTO> sampleDTOList;



    public  void test(){
        sampleDTOList = sampleClass.selectTestList();
        int size = sampleDTOList.size();
        System.out.println("test용"+size);
        int i =0;
        for(i= 0; i<size ; i++){
            System.out.println(sampleDTOList.get(i).getIdtset());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        test();
    }
}
