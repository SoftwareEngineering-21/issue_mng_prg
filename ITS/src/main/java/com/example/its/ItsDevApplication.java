package com.example.its;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@SpringBootApplication
@ActiveProfiles("test")
public class ItsDevApplication implements CommandLineRunner {

    private final DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    public ItsDevApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(ItsDevApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Url: " + connection.getMetaData().getURL());
            System.out.println("UserName: " + connection.getMetaData().getUserName());
        }
        jdbcTemplate.execute("INSERT INTO Products (prod_name, prod_price) values ('버킷햇', 6900)");

    }
}
