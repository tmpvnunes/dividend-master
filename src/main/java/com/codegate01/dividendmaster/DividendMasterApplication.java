package com.codegate01.dividendmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class DividendMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DividendMasterApplication.class, args);
    }

}
