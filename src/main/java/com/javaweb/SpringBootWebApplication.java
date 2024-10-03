package com.javaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PreDestroy;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @PreDestroy
    public void cleanup() {
        try {
            DriverManager.deregisterDriver(DriverManager.getDriver("jdbc:mysql://your_database_url"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
