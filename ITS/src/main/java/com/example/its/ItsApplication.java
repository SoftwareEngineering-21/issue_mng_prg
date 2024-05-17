package com.example.its;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.its.dataClassDB.ProjectDB;
import com.example.its.database.project.ProjectDBService;
import com.example.its.mybatis.SampleClass;
import com.example.its.mybatis.SampleDTO;


@SpringBootApplication
public class ItsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ItsApplication.class, args);
    }
    @Autowired
    public ProjectDBService pdbs;
    public  SampleClass sampleClass;

    public  List<SampleDTO> sampleDTOList;





    public  void test(){
        ProjectDB p = new ProjectDB("change", "test2", "test2");
        // System.out.println("test1");
        // pdbs.createProjectService(p);
        //String adminId = new String("test2");
        pdbs.updateProjectService(1, p);
        System.out.println("update");
        pdbs.deleteProjectService(3);
        System.out.println("delete");
        
        /*
        sampleDTOList = sampleClass.selectTestList();
        int size = sampleDTOList.size();
        System.out.println("test용"+size);
        int i =0;
        for(i= 0; i<size ; i++){
            System.out.println(sampleDTOList.get(i).idtset);
        }
        */
    }

    @Override
    public void run(String... args) throws Exception {
        test();
    }
}
