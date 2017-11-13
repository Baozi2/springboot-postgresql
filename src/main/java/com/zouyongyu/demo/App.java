package com.zouyongyu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main( String[] args ){
        System.out.println( "postgresql connect demo" );
        SpringApplication.run(App.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //jdbcTemplate.execute("INSERT INTO \"public\".\"user\" VALUES ('2', '2');");
        SqlRowSet srs = jdbcTemplate.queryForRowSet("select * from \"public\".\"user\"");
        int rowCount = 0;
        while (srs.next()) {
            System.out.println(srs.toString());
            System.out.println(srs.getString(1));
            rowCount++;
        }
        System.out.println("Number of records : " + rowCount);
    }
}
