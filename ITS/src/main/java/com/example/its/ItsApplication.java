package com.example.its;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.its.database.project.ProjectDBService;
import com.example.its.mybatis.SampleClass;
import com.example.its.mybatis.SampleDTO;

@EnableAsync
@SpringBootApplication
public class ItsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ItsApplication.class, args);
    }

    @Autowired
    public ProjectDBService pdbs;
    @Autowired
    public  SampleClass sampleClass;

    public  List<SampleDTO> sampleDTOList;

    
    public  void test(){
        // ProjectDB p = new ProjectDB("change", "test2", "test2");
        // pdbs.deleteProjectService(3);
        // System.out.println("delete");

    }
    
    @Override
    public void run(String... args) throws Exception {
        sampleClass.test1();
        pdbs.createProjectService("aaa", "ab", "test");
        test();
    }
}
